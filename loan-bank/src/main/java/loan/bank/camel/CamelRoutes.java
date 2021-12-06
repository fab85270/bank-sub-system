package loan.bank.camel;

import loan.bank.exception.LoanProposalException;
import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectDTO;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @Inject
    ProjectGateway projectGateway;

    @Inject
    CamelContext camelContext;

    @ConfigProperty(name = "loan.bank.id")
    int idBank;

    @ConfigProperty(name = "loan.bank.name")
    String nameBank;

    @ConfigProperty(name = "loan.bank.smtp.user")
    String smtpUser;

    @ConfigProperty(name = "loan.bank.smtp.password")
    String smtpPassword;

    @ConfigProperty(name = "loan.bank.smtp.host")
    String smtpHost;

    @ConfigProperty(name = "loan.bank.smtp.port")
    String smtpPort;

    @Override
    public void configure() throws Exception {
        camelContext.setTracing(true);

        onException(LoanProposalException.LoanProposalRefusedException.class)
                .handled(true)
                .marshal()
                .json(ProjectDTO.class)
                .setHeader("approved", simple("false"));

        from("jms:queue/bank?exchangePattern=InOut")
                .filter(header("idBank").isEqualTo(idBank))
                .unmarshal()
                .json(ProjectDTO.class)
                .bean(projectGateway, "createLoanProposal")
                .setHeader("approved", simple("true"))
                .marshal()
                .json(LoanProposalDTO.class);


        from("jms:queue/bank/proposals")
                .filter(header("idBank").isEqualTo(idBank))
                .choice()
                .when(header("status").isEqualTo("approved"))
                .unmarshal()
                .json(LoanProposalDTO.class)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {

                        System.out.println(exchange.getMessage().getBody());
                        LoanProposalDTO proposal = exchange.getMessage().getMandatoryBody(LoanProposalDTO.class);
                        ProjectDTO project = proposal.getProjectId();
                        exchange.getMessage().setHeaders(new HashMap<>());
                        exchange.getMessage().setHeader("to", project.getBorrowerId().getEmail());
                        exchange.getMessage().setHeader("from", "vendor@miage.dev");
                        exchange.getMessage().setHeader("contentType", "text/html");
                        exchange.getMessage().setHeader("subject", "Votre proposition d'emprunt -" + nameBank);
                        exchange.getMessage().setBody("Bonjour " + project.getBorrowerId().getLastName() + " " + project.getBorrowerId().getFirstName() +
                                ",<br><br> Votre emprunt a hauteur de " +
                                project.getRequiredValue() + " euros a ete accepte,<br>Felicitations !!" +
                                "<br>Nous vous laissons reprendre contact avec nous afin d'effectuer les démarches administratives" +
                                "<br><br>Bien cordialement," +
                                "<br>" + nameBank

                        );
                    }
                })
                .log("Envoie du projet au borrower ${body} ${headers}")
                //Port 587 car le port 587 est le port par défaut pour la soumission SMTP sur le web moderne
                .to("smtp:" + smtpHost + ":" + smtpPort + "?username=" + smtpUser + "&password=" + smtpPassword);
    }
}
