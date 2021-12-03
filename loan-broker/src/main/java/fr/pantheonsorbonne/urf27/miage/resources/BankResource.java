package fr.pantheonsorbonne.urf27.miage.resources;

import fr.pantheonsorbonne.urf27.miage.exception.BankExceptions;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.service.BankService;
import fr.pantheonsorbonne.urf27.miage.service.ProjectSentBankServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/bank")
public class BankResource {

    @Inject
    ProjectSentBankServiceImpl projectSentBankService;

    @Inject
    BankService bankService;

    /*
     * Fonction permettant la creation d'une banque
     */

    @Path("/bank")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Bank createBank(Bank bank) throws EntityNotFoundException, BankExceptions.BankAlreadyExists {
        return bankService.createBank(bank);
    }

    /*
     * fonction permettant de retourner toutes les banques présentes dans la BDD
     */
    @Path("/banks")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Bank> getBanks() throws EntityNotFoundException {
        return bankService.getBanks();

    }

}