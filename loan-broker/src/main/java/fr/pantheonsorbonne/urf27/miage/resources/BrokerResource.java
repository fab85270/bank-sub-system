package fr.pantheonsorbonne.urf27.miage.resources;

import fr.pantheonsorbonne.urf27.miage.dao.BankDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.BrokerDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Broker;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.service.BrokerServiceImpl;
import fr.pantheonsorbonne.urf27.miage.service.ProjectServiceImpl;
import loan.commons.dto.DummyDTO;
import loan.commons.dto.SelectProjetBankDTO;
import loan.commons.dto.ContratType;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.time.LocalDate;
import java.util.Collection;

@Path("/broker")
public class BrokerResource {

    @Inject
    BrokerDAOImpl brokerDAO;

    @Inject
    BankDAOImpl bankDAO;

    @Inject
    ProjectServiceImpl projectService;

    @Inject
    BankDAOImpl bankService;

    @Inject
    BrokerServiceImpl brokerService;

    @Path(("/test"))
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Broker test() {
        return brokerDAO.createNewBroker("Anxhela", "Joti", "ab@gmail.com");
    }

    @Path("/getBankPartners/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Bank> getBankPartners(@PathParam("id") int id) throws EntityNotFoundException {
//        brokerDAO.createNewBroker("Anxhela", "Joti", "ab@gmail.com");
        return brokerService.getBrokersBanks(id);
    }

    @Path("/createBroker")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void createBroker(Broker broker) {
        brokerDAO.createNewBroker(broker);
    }


    @Path("/createBank")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void createBank(Bank bank) {
        bankDAO.createNewBank(bank);
    }


    /*Méthode chargée de créer un nouveau projet Client suite à la saisie de ses informations dans le formulaire */

    @Path("/createProjectClient")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void createProjectClient(DummyDTO application) {

        /*On récupère toutes les données reçue depuis le formulaire */
        String description = application.getDescription();
        LocalDate dateDebut = application.getDateDepart();
        LocalDate dateFin = application.getDateFin();
        double sommeVoulu = application.getSommeVoulu();
        ContratType contract = application.getWorkStatut();


        /* Création du nouveau projet client suite aux informations obtenues dans le formulaire */

        projectService.createNewProjectClient(description, dateDebut, dateFin, sommeVoulu, contract);

    }


    /* Les deux Méthodes afin de gérer l'affichage des différents projets qui seront présentés au broker */

    /* Méthode chargée de récupérer tous les projects clients réunis dans la base de données pour les afficher ensuite */
    @Path("/getProject")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Project> getProject() throws EntityNotFoundException {
        return projectService.getAllProject();
    }

    /*Chargée de la reception de l'identifiant du projet séléctionné par le broker*/
    @Path("/sendIdProject")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void sendIdProject(SelectProjetBankDTO application) throws EntityNotFoundException {

        /* Récupération de l'ID du projetClient retenu par le broker*/
        int idProject = application.getIdProject();

        /* Une fois envoyé, l'attribut isDelivered du projet Client devra changer d'état => est envoyé*/

        projectService.changeIsDelivered(idProject);

        /* Création d'un projet DTO afin de pouvoir l'envoyer par la suite (il possède Estate.. et tout) */

        //TODO A FAIRE

    }
}



