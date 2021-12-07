package fr.pantheonsorbonne.urf27.miage.camel.gateways;

import fr.pantheonsorbonne.urf27.miage.exception.ProjectExceptions;
import fr.pantheonsorbonne.urf27.miage.model.LoanProposal;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.service.LoanProposalService;
import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectDTO;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class LoanProposalGatewayImpl implements LoanProposalGateway {

    @Inject
    LoanProposalService loanProposalService;

    @Inject
    ProjectGateway projectGateway;

    @Override
    public LoanProposalDTO createLoanProposal(LoanProposalDTO proposalDTO) throws ProjectExceptions.ProjectPublicKeyNotFound {
        ModelMapper modelMapper = new ModelMapper();
        LoanProposal proposal = loanProposalService.createLoanProposal(proposalDTO);
        projectGateway.updateStatusApproved(proposalDTO.getProjectId(), proposalDTO.getIdBank());
        return modelMapper.map(proposal, LoanProposalDTO.class);
    }
}
