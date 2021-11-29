package loan.bank.camel;

import loan.bank.service.ProjectService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @Inject
    ProjectService projectService;

    @Override
    public void configure() throws Exception {
        from("jms:joti_bank")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println(exchange.getContext());
                    }
                });
//                .unmarshal().json(ProjectSentByBrokerDTO.class)
//                .bean(projectService, "analyseProject")
//                .marshal()
//                .json();

    }
}
