package fr.pantheonsorbonne.urf27.miage.resources;

import fr.pantheonsorbonne.urf27.miage.dao.BankDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.BankExceptions;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.service.BrokerServiceImpl;
import fr.pantheonsorbonne.urf27.miage.service.ProjectServiceImpl;
import loan.commons.dto.ProjectDTO;
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

    @Path("/getBanks")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Bank> getBanks() throws EntityNotFoundException {
        return bankDAO.getBanks();
    }


    /*Chargée de la reception de l'identifiant du projet séléctionné par le broker*/
    /*@Path("/sendIdProject")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void sendIdProject(SelectProjetBankDTO application) throws EntityNotFoundException {

        /* Récupération de l'ID du projetClient retenu par le broker*/

        //int idProject = application.getIdProject();

        /* Une fois envoyé, l'attribut isDelivered du projet Client devra changer d'état => est envoyé*/

        /*projectService.changeIsDelivered(idProject);

        /* Création d'un projet DTO afin de pouvoir l'envoyer par la suite (il possède Estate.. et tout) */

        //TODO A FAIRE

   // }
}
