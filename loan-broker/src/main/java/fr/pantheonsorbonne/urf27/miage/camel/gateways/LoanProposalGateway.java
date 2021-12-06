package fr.pantheonsorbonne.urf27.miage.camel.gateways;

import fr.pantheonsorbonne.urf27.miage.exception.ProjectExceptions;
import loan.commons.dto.LoanProposalDTO;

public interface LoanProposalGateway {

    LoanProposalDTO createLoanProposal(LoanProposalDTO proposalDTO) throws ProjectExceptions.ProjectPublicKeyNotFound;
}
