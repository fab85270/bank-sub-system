package fr.pantheonsorbonne.urf27.miage.camel.routes;

import fr.pantheonsorbonne.urf27.miage.camel.gateways.LoanProposalGateway;
import fr.pantheonsorbonne.urf27.miage.camel.gateways.ProjectGateway;
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
    LoanProposalGateway loanProposalGateway;

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.bank1.id")
    int bank1Id;

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.bank2.id")
    int bank2Id;

    @Override
    public void configure() {

        from("direct:cli")
                .marshal().json()
                .to("jms:queue/bank?exchangePattern=InOut")
                .choice()
                .when(header("approved").isEqualTo(false))
                .unmarshal()
                .json(ProjectDTO.class)
                .bean(projectGateway, "updateStatusRejected");


        from("jms:queue/bankProposals" + bank1Id)
                .unmarshal()
                .json(LoanProposalDTO.class)
                .bean(loanProposalGateway, "createLoanProposal");


        from("jms:queue/bankProposals" + bank2Id)
                .unmarshal()
                .json(LoanProposalDTO.class)
                .bean(loanProposalGateway, "createLoanProposal");

    }
}
