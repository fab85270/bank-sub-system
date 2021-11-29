package fr.pantheonsorbonne.urf27.miage.camel.gateways;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {


    @Inject
    CamelContext camelContext;

    @Override
    public void configure() {

        from("direct:cli")
                .marshal().json()
                .to("jms:joti_bank");
    }
}
