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
//        from("jms:queue/bank")
//                .process(new Processor() {
//                    @Override
//                    public void process(Exchange exchange) throws Exception {
//                        System.out.println("test");
//                        System.out.println(exchange.getContext());
//                    }
//                });
//                .unmarshal().json(ProjectDTO.class)
//                .process(new Processor() {
//                    @Override
//                    public void process(Exchange exchange) throws Exception {
//                        System.out.println("ERDHII ===");
//                    }
//                });
//                .bean(projectService, "analyseProject")
//                .marshal()
//                .json();

//        from("file:data/test")
//                .to("jms:queue/data");
        from("jms:queue/data")
//                .unmarshal().json(ProjectDTO.class)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("ketu ");
                        System.out.println("test");
                    }
                });
    }
}
