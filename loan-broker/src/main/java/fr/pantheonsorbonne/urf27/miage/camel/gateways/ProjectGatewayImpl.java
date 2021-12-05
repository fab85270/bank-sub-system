package fr.pantheonsorbonne.urf27.miage.camel.gateways;

import fr.pantheonsorbonne.urf27.miage.exception.ProjectExceptions;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.service.ProjectSentBankService;
import fr.pantheonsorbonne.urf27.miage.service.ProjectSentBankServiceImpl;
import fr.pantheonsorbonne.urf27.miage.service.ProjectService;
import fr.pantheonsorbonne.urf27.miage.service.ProjectServiceImpl;
import loan.commons.dto.ProjectDTO;
import org.apache.camel.CamelContext;
import org.apache.camel.Header;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import java.io.IOException;

@ApplicationScoped
public class ProjectGatewayImpl implements ProjectGateway {

    @Inject
    CamelContext context;

    @Inject
    ProjectSentBankService projectSentBankService;

    @Inject
    ProjectService projectService;

    @Override
    public void sendProjectToBank(ProjectDTO projectDTO, int idBank) {
        try (ProducerTemplate producer = context.createProducerTemplate()) {
            producer.sendBodyAndHeader("direct:cli", projectDTO, "idBank", idBank);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatusRejected(ProjectDTO projectDto, @Header("idBank") int idBank) throws ProjectExceptions.ProjectPublicKeyNotFound {
        Project project = projectService.getProjectByPublicKey(projectDto.getPublicKey());
        projectSentBankService.updateStatusRejected(project.getProjectId(), idBank);
    }
}
