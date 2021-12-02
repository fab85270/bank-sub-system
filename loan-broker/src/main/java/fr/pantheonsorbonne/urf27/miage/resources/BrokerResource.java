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
import org.hibernate.internal.build.AllowSysOut;
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
    ProjectDAO projectDAO;

    @Inject
    BankService bankService;

    @Inject
    BrokerServiceImpl brokerService;

    @Inject
    ProjectServiceImpl projectService;

    @Inject
    LoanProposalService loanProposalService;

    @Inject
    ProjectGateway projectGateway;

    @Path("/getBankPartners/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Bank> getBankPartners(@PathParam("id") int id) throws EntityNotFoundException {
        return brokerService.getBrokersBanks(id);
    }

    @Path("/createBank")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Bank createBank(Bank bank) throws EntityNotFoundException, BankExceptions.BankAlreadyExists {
        return bankService.createBank(bank);
    }


    @Path("/createProject")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public ProjectDTO createProject(Project project) {

        //bankService.createBankTest();
        projectService.createProject(project.getBorrowerId(), project.getRealEstateId(), project.getProjectDescription(),
                project.getProposalDate(), project.getExpirationDate(), project.getRequiredValue(), project.getDurationMax());

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(project, ProjectDTO.class);
    }

    @Path("/selectProject/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProjectDTO selectProject(@PathParam("id") int id){
        System.out.println(projectService.getProject(id));
        projectGateway.sendProjectToBank(projectService.getProject(id));
        return null;
    }

    /* Les deux Méthodes afin de gérer l'affichage des différents projets qui seront présentés au broker */

    /* Méthode chargée de récupérer tous les projects clients réunis dans la base de données pour les afficher ensuite */

    @Path("/getProject")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Project> getProject() throws EntityNotFoundException {
        return projectService.getAllProject();
    }

    @Path("/getLoanProposal/")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public  Collection<LoanProposal> getLoanProposal() throws EntityNotFoundException{
        return loanProposalService.getAllLoanProposal();
    }

    @Path("/mailUsed/{mail}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Boolean mailUsed(@PathParam("mail") String mail) throws EntityNotFoundException {
        System.out.println(mail);
        return projectService.mailUsed(mail);
    }

    @Path("/getBanks")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Bank> getBanks() throws EntityNotFoundException {
        return bankService.getBanks();

    }

    @Path("/isSent/{bank}/{projet}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Boolean isSent(@PathParam("bank") int idBank, @PathParam("projet") int idProject) throws EntityNotFoundException {

        /* On récupère les objets associés aux identifiants obtenus */
        Bank b = bankService.findBank(idBank);
        Project p = projectDAO.findProject(idProject);

        /* On recherche ainsi si le projet à déja été envoyée à cette banque séléctionnée */

        return projectSentBankService.isSent(b,p);

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
        Project p = projectDAO.findProject(idProject);


        /* Instancier la classe ProjectSentBank selon le project envoyé à une banque donnée */

        projectSentBankService.createSentBankProject(p,b);

        /* Une fois envoyé, l'attribut isDelivered du projet Client devra changer d'état => est envoyé*/

        //projectService.changeIsDelivered(idProject);

        /* Création d'un projet DTO afin de pouvoir l'envoyer par la suite (il possède Estate.. et tout) */

        //TODO A FAIRE

        // }
    }
}