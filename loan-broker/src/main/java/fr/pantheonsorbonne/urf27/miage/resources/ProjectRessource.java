package fr.pantheonsorbonne.urf27.miage.resources;

import fr.pantheonsorbonne.urf27.miage.camel.gateways.ProjectGateway;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.service.BankService;
import fr.pantheonsorbonne.urf27.miage.service.ProjectSentBankServiceImpl;
import fr.pantheonsorbonne.urf27.miage.service.ProjectServiceImpl;
import loan.commons.dto.ProjectDTO;
import loan.commons.dto.SelectProjetBankDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/project")
public class ProjectRessource {

    @Inject
    ProjectSentBankServiceImpl projectSentBankService;

    @Inject
    BankService bankService;

    @Inject
    ProjectServiceImpl projectService;

    @Inject
    ProjectGateway projectGateway;

    @Path("/banks/{bank}/project/{projet}")
    @HEAD
    public Response isSent(@PathParam("bank") int idBank, @PathParam("projet") int idProject) throws EntityNotFoundException {

        //Recherche de la bank
        Bank b = bankService.findBank(idBank);
        //Recherche du projet
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
    @Path("/project")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void sendIdProject(SelectProjetBankDTO application) throws EntityNotFoundException {

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

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProjectDTO selectProject(@PathParam("id") int id){
        System.out.println(projectService.getProject(id));
        projectGateway.sendProjectToBank(projectService.getProject(id));
        return null;
    }
}