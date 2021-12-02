package fr.pantheonsorbonne.urf27.miage.resources;

import fr.pantheonsorbonne.urf27.miage.camel.gateways.ProjectGateway;
import fr.pantheonsorbonne.urf27.miage.dao.BankDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.BankExceptions;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.LoanProposal;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.ProjectSentBank;
import fr.pantheonsorbonne.urf27.miage.service.*;
import fr.pantheonsorbonne.urf27.miage.dao.ProjectSentBankDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.ProjectDAO;
import loan.commons.dto.ProjectDTO;
import loan.commons.dto.SelectProjetBankDTO;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/broker")
public class BrokerResource {

    @Inject
    ProjectSentBankServiceImpl projectSentBankService;

    @Inject
    BankService bankService;

    @Inject
    BrokerServiceImpl brokerService;

    @Inject
    ProjectServiceImpl projectService;

    @Inject
    ProjectGateway projectGateway;

    @Inject
    LoanProposalService loanProposalService;

    @Path("/isSent/{bank}/{projet}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Boolean isSent(@PathParam("bank") int idBank, @PathParam("projet") int idProject) throws EntityNotFoundException {

        /* On récupère les objets associés aux identifiants obtenus */
        Bank b = bankService.findBank(idBank);
        Project p = projectService.findProject(idProject);

        /* On recherche ainsi si le projet à déja été envoyée à cette banque séléctionnée */

        return projectSentBankService.isSent(b,p);

    }


    @Path("/selectProject/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProjectDTO selectProject(@PathParam("id") int id){
        System.out.println(projectService.getProject(id));
        projectGateway.sendProjectToBank(projectService.getProject(id));
        return null;
    }

    /*Chargée de la reception de l'identifiant du projet et de la banque séléctionnée par le broker*/
    @Path("/sendIdProject")
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

}