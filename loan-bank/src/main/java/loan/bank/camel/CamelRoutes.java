package loan.bank.camel;

import loan.bank.service.ProjectService;
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

    @ConfigProperty(name = "loan.bank.name")
    String nameBank;

    @Override
    public void configure() throws Exception {

        //Reception du projet venant du Broker
        camelContext.setTracing(true);
        from("jms:queue/bank")
                .unmarshal()
                .json(ProjectDTO.class)
                //.bean(projectGateway, "isOk")
                //.marshal()
                //.json()
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {

                    System.out.println(exchange.getMessage().getBody());
                    ProjectDTO projetDTO = exchange.getMessage().getMandatoryBody(ProjectDTO.class);
                    exchange.getMessage().setHeaders(new HashMap<>());
                    exchange.getMessage().setHeader("to", projetDTO.getBorrowerId().getEmail());
                    exchange.getMessage().setHeader("from", "vendor@miage.dev");
                    exchange.getMessage().setHeader("contentType", "text/html");
                    exchange.getMessage().setHeader("subject", "Votre proposition d'emprunt - "+nameBank);
                    exchange.getMessage().setBody("Bonjour Mr "+projetDTO.getBorrowerId().getLastName()+" "+projetDTO.getBorrowerId().getFirstName()+",<br><br> Votre emprunt à hauteur de "+
                            projetDTO.getProjectRequiredValue()+"€ a ete accepte,<br>Félicitations !!"+
                            "<br>Nous vous laissons reprendre contact avec nous afin d'effectuer les démarches administratives"+
                            "<br><br>Bien cordialement,"+
                            "<br>"+nameBank

                    );
                }
            })
                .log("Envoie du projet au borrower ${body} ${headers}")
                //Port 587 car le port 587 est le port par défaut pour la soumission SMTP sur le web moderne
                .to("smtp:" + "mail.gandi.net" + ":" + "587" + "?username=" + "vendor@miage.dev" + "&password=" + "ahh)aeD3ies3");

    }
}
