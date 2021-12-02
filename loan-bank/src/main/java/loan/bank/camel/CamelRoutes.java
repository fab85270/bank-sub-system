package loan.bank.camel;

import loan.bank.service.ProjectService;
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
    ProjectService projectService;

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {
        camelContext.setTracing(true);
        from("jms:queue/bank")
                .unmarshal().json(ProjectDTO.class)
                .bean(projectService, "analyseProject")
                .marshal()
                .json();
    }
}