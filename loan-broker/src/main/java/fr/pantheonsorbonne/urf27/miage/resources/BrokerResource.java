package fr.pantheonsorbonne.urf27.miage.resources;

import fr.pantheonsorbonne.urf27.miage.dao.BankDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.BankExceptions;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.service.BrokerServiceImpl;
import fr.pantheonsorbonne.urf27.miage.service.ProjectServiceImpl;
import loan.commons.dto.ProjectDTO;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/broker")
public class BrokerResource {

    @Inject
    BankDAOImpl bankDAO;


    @Inject
    BankDAOImpl bankService;

    @Inject
    BrokerServiceImpl brokerService;

    @Inject
    ProjectServiceImpl projectService;
    /*
    @Path(("/test"))
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Broker test() {
        return brokerDAO.createNewBroker("Anxhela", "Joti", "ab@gmail.com");
    }

     */

    @Path("/getBankPartners/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Bank> getBankPartners(@PathParam("id") int id) throws EntityNotFoundException {
//        brokerDAO.createNewBroker("Anxhela", "Joti", "ab@gmail.com");
        return brokerService.getBrokersBanks(id);
    }

    /*
    @Path("/createBroker")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void createBroker(Broker broker) {
        brokerDAO.createNewBroker(broker);

    }

     */

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
//        System.out.println(project.getRealEstateId());
        projectService.createProject(project.getRealEstateId(), project.getProjectDescription(), project.getRequiredValue(),
                project.getDurationMax());
//        System.out.println(project);
        return null;
    }
}
