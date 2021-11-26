package fr.pantheonsorbonne.urf27.miage.resources;

import fr.pantheonsorbonne.urf27.miage.dao.BankDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.BrokerDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.ProjectDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Broker;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.service.BrokerServiceImpl;
import fr.pantheonsorbonne.urf27.miage.service.ProjectService;
import fr.pantheonsorbonne.urf27.miage.service.ProjectServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

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



    @Path("/getProject")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Project> getProject() throws EntityNotFoundException {
        return projectService.getAllProject();
    }

    @Path("/sendIdProject")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void sendIdProject() {

    }


}
