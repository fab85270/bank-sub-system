package fr.pantheonsorbonne.urf27.miage.camel.gateways;

import loan.commons.dto.ProjectDTO;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class ProjectGatewayImpl implements ProjectGateway {

    @Inject
    CamelContext context;

    @Override
    public void sendProjectToBank(ProjectDTO projectDTO) {
        try (ProducerTemplate producer = context.createProducerTemplate()) {
            producer.sendBody("direct:cli", projectDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
