package fr.pantheonsorbonne.urf27.miage.camel.gateways;

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
    }
}
