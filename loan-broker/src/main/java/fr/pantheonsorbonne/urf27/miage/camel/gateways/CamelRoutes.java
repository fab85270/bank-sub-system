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

    @Inject
    CamelContext camelContext;

    public int idBank;

    @Override
    public void configure() {
        from("direct:cli")
                .marshal().json()
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        idBank = Integer.parseInt(exchange.getMessage().getHeader("idBank").toString());
                        System.out.println("IDBAAANK -=== " + idBank);
                        exchange.setProperty("idBank", idBank);
                    }
                })
                .to("jms:queue/bank?exchangePattern=InOut")
                .choice()
                .when(header("approved").isEqualTo(false))
                .unmarshal()
                .json(ProjectDTO.class)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        exchange.getMessage().setHeader("idBank", 1);
                    }
                })
                .bean(projectGateway, "updateStatusRejected")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println(exchange.getMessage().getBody());
                    }
                });
    }
}
