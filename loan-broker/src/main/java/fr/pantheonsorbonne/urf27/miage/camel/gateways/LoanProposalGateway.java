package fr.pantheonsorbonne.urf27.miage.camel.gateways;

import loan.commons.dto.LoanProposalDTO;

public interface LoanProposalGateway {

    void createLoanProposal(LoanProposalDTO proposalDTO);
}
