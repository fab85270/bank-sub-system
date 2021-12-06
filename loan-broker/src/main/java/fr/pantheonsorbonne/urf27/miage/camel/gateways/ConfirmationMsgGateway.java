package fr.pantheonsorbonne.urf27.miage.camel.gateways;

import loan.commons.dto.LoanProposalDTO;

public interface ConfirmationMsgGateway {

    void sendConfirmationMessageToBank(LoanProposalDTO proposalDTO, int bankId);
}
