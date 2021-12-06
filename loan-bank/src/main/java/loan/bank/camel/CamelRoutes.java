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

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @Inject
    ProjectGateway projectGateway;

    @Inject
    CamelContext camelContext;

    @ConfigProperty(name = "loan.bank.id")
    int idBank;

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
                .json(LoanProposalDTO.class);
    }
}
