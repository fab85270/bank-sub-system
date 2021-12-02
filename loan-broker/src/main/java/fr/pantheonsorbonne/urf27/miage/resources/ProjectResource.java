package fr.pantheonsorbonne.urf27.miage.resources;

import fr.pantheonsorbonne.urf27.miage.camel.gateways.ProjectGateway;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.service.ProjectServiceImpl;
import loan.commons.dto.ProjectDTO;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/project")
public class ProjectResource {

    @Inject
    ProjectServiceImpl projectService;

    @Inject
    ProjectGateway projectGateway;

    @Path("/project")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public ProjectDTO createProject(Project project) {

        //bankService.createBankTest();
        projectService.createProject(project.getBorrowerId(), project.getRealEstateId(), project.getProjectDescription(),
                project.getProposalDate(), project.getExpirationDate(), project.getRequiredValue(), project.getDurationMax());

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(project, ProjectDTO.class);
    }

    @Path("/projects")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Project> getProject() throws EntityNotFoundException {
        return projectService.getAllProject();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProjectDTO selectProject(@PathParam("id") int id){
        System.out.println(projectService.getProject(id));
        projectGateway.sendProjectToBank(projectService.getProject(id));
        return null;
    }
}
