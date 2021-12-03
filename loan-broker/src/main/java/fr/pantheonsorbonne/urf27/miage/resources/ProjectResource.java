package fr.pantheonsorbonne.urf27.miage.resources;

import fr.pantheonsorbonne.urf27.miage.camel.gateways.ProjectGateway;
import fr.pantheonsorbonne.urf27.miage.dao.BankDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.BankExceptions;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.exception.ProjectExceptions;
import fr.pantheonsorbonne.urf27.miage.model.Address;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.service.BankService;
import fr.pantheonsorbonne.urf27.miage.service.ProjectSentBankServiceImpl;
import fr.pantheonsorbonne.urf27.miage.service.ProjectServiceImpl;
import loan.commons.dto.ProjectDTO;
import loan.commons.dto.SelectProjetBankDTO;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/project")
public class ProjectResource {

    @Inject
    ProjectServiceImpl projectService;

    @Inject
    ProjectGateway projectGateway;

    @Inject
    ProjectSentBankServiceImpl projectSentBankService;

    @Inject
    BankDAOImpl bankdao;

    @Inject
    BankService bankService;

    /*
    Permet la creation d'un projet
     */
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

    /*
    Permet l'affichage de tous les projets de la BDD'
     */
    @Path("/projects")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Project> getProject() throws ProjectExceptions.ProjectsNotFound {
        return projectService.getAllProject();
    }

    /*
    Permet de selectionner un seul projet
     */
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProjectDTO selectProject(@PathParam("id") int id){
        System.out.println(projectService.getProject(id));
        projectGateway.sendProjectToBank(projectService.getProject(id));
        return null;
    }

    /*
    Renvoie dans le header si le projet a deja ete envoye aux banques
     */
    @Path("/banks/{idBank}/banks/{idProject}")
    @HEAD
    public Response isSent(@PathParam("idBank") int idBank, @PathParam("idProject") int idProject) throws  ProjectExceptions.ProjectNotFoundId, BankExceptions.BanksNotFoundId {

        /* On récupère les objets associés aux identifiants obtenus */
        Bank b = bankService.findBank(idBank);
        Project p = projectService.findProject(idProject);

        if(projectSentBankService.isSent(b,p)){
            Response r = Response
                    .status(Response.Status.FOUND)
                    .build();
            return r;
        }else{
            Response r = Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
            return r;
        }
    }

    /*Chargée de la reception de l'identifiant du projet et de la banque séléctionnée par le broker*/
    @Path("/projectBank")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void sendIdProject(SelectProjetBankDTO application) throws ProjectExceptions.ProjectNotFoundId, BankExceptions.BanksNotFoundId {

        /*Affichage de l'object JSON obtenu */
        System.out.println(application.toString());

        /* Récupération de l'ID du projetClient retenu par le broker*/

        int idProject = application.getIdProject();

        /* Récupération de l'ID de la banque retenue par le broker */

        int idBank = application.getIdBank();


        /* Récupération des objets associés aux ID de project et le nom de la Bank */

        Bank b = bankService.findBank(idBank);
        Project p = projectService.findProject(idProject);


        /* Instancier la classe ProjectSentBank selon le project envoyé à une banque donnée */

        projectSentBankService.createSentBankProject(p,b);

        /* Une fois envoyé, l'attribut isDelivered du projet Client devra changer d'état => est envoyé*/

        //projectService.changeIsDelivered(idProject);

        /* Création d'un projet DTO afin de pouvoir l'envoyer par la suite (il possède Estate.. et tout) */

        //TODO A FAIRE

        // }
    }

}