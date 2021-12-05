package loan.bank.camel;

import loan.bank.exception.LoanProposalException;
import loan.commons.dto.ProjectDTO;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @Inject
    ProjectGatewayImpl projectGateway;

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
//                .setBody(simple("Project not eligible"));

        from("jms:queue/bank/" + idBank + "?exchangePattern=InOut")
                .unmarshal()
                .json(ProjectDTO.class)
                .bean(projectGateway, "isProjectEligible")
                .marshal()
                .json();
    }
}
