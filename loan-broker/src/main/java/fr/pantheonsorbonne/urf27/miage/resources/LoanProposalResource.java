package fr.pantheonsorbonne.urf27.miage.resources;

import fr.pantheonsorbonne.urf27.miage.exception.LoanProposalExceptions;
import fr.pantheonsorbonne.urf27.miage.model.LoanProposal;
import fr.pantheonsorbonne.urf27.miage.service.LoanProposalService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/loanProposal")
public class LoanProposalResource {

    @Inject
    LoanProposalService loanProposalService;

    //Retourne tous les loanProposal present dans la BDD
    @Path("/loanProposals/")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<LoanProposal> getLoanProposal() throws LoanProposalExceptions.LoanProposalsNotFound  {
        return loanProposalService.getAllLoanProposal();
    }
}