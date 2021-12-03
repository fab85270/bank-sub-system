package fr.pantheonsorbonne.urf27.miage.camel.gateways;

import fr.pantheonsorbonne.urf27.miage.service.ProjectServiceImpl;
import loan.commons.dto.ProjectDTO;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {


    @Inject
    ProjectServiceImpl projectService;

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() {

        from("direct:cli")
                .marshal().json()
                .to("jms:queue/bank");
    }
}
