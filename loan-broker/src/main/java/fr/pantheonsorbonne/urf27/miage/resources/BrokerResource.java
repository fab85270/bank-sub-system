package fr.pantheonsorbonne.urf27.miage.resources;

import fr.pantheonsorbonne.urf27.miage.dao.BankDAO;
import fr.pantheonsorbonne.urf27.miage.dao.BankDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.BankExceptions;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Address;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.service.BrokerServiceImpl;
import fr.pantheonsorbonne.urf27.miage.service.ProjectServiceImpl;
import loan.commons.dto.ProjectDTO;
import loan.commons.dto.SelectProjetBankDTO;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.Collection;

@Path("/broker")
public class BrokerResource {

    @Inject
    BankDAOImpl bankDAO;

    @Inject
    BrokerServiceImpl brokerService;

    @Inject
    ProjectServiceImpl projectService;

    @Path("/getBankPartners/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Bank> getBankPartners(@PathParam("id") int id) throws EntityNotFoundException {
        return brokerService.getBrokersBanks(id);
    }

    @Path("/createBank")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Bank createBank(Bank bank) throws BankExceptions.BankAlreadyExists {
        return bankDAO.createNewBank(bank);
    }


    @Path("/createProject")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public ProjectDTO createProject(Project project) {

       // bankDAO.createBankTest();
        projectService.createProject(project.getBorrowerId(), project.getRealEstateId(), project.getProjectDescription(),
                project.getProposalDate(), project.getExpirationDate(), project.getRequiredValue(), project.getDurationMax());

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(project, ProjectDTO.class);
    }

    /* Les deux Méthodes afin de gérer l'affichage des différents projets qui seront présentés au broker */

    /* Méthode chargée de récupérer tous les projects clients réunis dans la base de données pour les afficher ensuite */

    @Path("/getProject")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Project> getProject() throws EntityNotFoundException {
        return projectService.getAllProject();
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
        return bankDAO.getBanks();

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

        /* Une fois envoyé, l'attribut isDelivered du projet Client devra changer d'état => est envoyé*/

        projectService.changeIsDelivered(idProject);

        /* Création d'un projet DTO afin de pouvoir l'envoyer par la suite (il possède Estate.. et tout) */

        //TODO A FAIRE

        // }
    }
}
