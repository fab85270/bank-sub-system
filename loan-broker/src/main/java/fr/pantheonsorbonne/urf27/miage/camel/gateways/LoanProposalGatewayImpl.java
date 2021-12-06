package fr.pantheonsorbonne.urf27.miage.camel.gateways;

import fr.pantheonsorbonne.urf27.miage.service.LoanProposalService;
import loan.commons.dto.LoanProposalDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class LoanProposalGatewayImpl implements LoanProposalGateway{

    @Inject
    LoanProposalService loanProposalService;

    @Override
    public void createLoanProposal(LoanProposalDTO proposalDTO){
        System.out.println("ERDHII");
        System.out.println(proposalDTO);
        loanProposalService.createLoanProposal(proposalDTO);
    }
}
