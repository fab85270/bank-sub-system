package fr.pantheonsorbonne.urf27.miage.resources;

import fr.pantheonsorbonne.urf27.miage.camel.gateways.ConfirmationMsgGateway;
import fr.pantheonsorbonne.urf27.miage.exception.LoanProposalExceptions;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.LoanProposal;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.service.LoanProposalService;
import loan.commons.dto.LoanProposalDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/loanProposal")
public class LoanProposalResource {

    @Inject
    LoanProposalService loanProposalService;

    @Inject
    ConfirmationMsgGateway confirmationMsgGateway;

    //Retourne tous les loanProposal present dans la BDD
    @Path("/loanProposals/")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<LoanProposal> getLoanProposal() throws LoanProposalExceptions.LoanProposalsNotFound {
        return loanProposalService.getAllLoanProposal();
    }

    @Path("/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public void acceptLoanProposal(@PathParam("id") int proposalId) {
        LoanProposal proposal = loanProposalService.getLoanProposal(proposalId);
        loanProposalService.updateApprovalStatus(proposalId);
        ModelMapper modelMapper = new ModelMapper();
        LoanProposalDTO proposalDto = modelMapper.map(proposal, LoanProposalDTO.class);
        confirmationMsgGateway.sendConfirmationMessageToBank(proposalDto, proposal.getIdBank());
    }

    @Path("/{id}")
    @HEAD
    public Response isProposalAlreadyAccepted(@PathParam("id") int proposalId) {
        Response.Status status = (loanProposalService.isProposalAlreadyAccepted(proposalId))
                ? Response.Status.FOUND
                : Response.Status.NOT_FOUND;
        return Response.status(status).build();
    }
}