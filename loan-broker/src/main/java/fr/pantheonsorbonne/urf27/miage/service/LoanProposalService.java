package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.exception.LoanProposalExceptions;
import fr.pantheonsorbonne.urf27.miage.exception.ProjectExceptions;
import fr.pantheonsorbonne.urf27.miage.model.LoanProposal;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import loan.commons.dto.LoanProposalDTO;

import java.util.Collection;

public interface LoanProposalService {
    Collection<LoanProposal> getAllLoanProposal() throws LoanProposalExceptions.LoanProposalsNotFound;

    LoanProposal createLoanProposal(LoanProposalDTO proposalDTO) throws ProjectExceptions.ProjectPublicKeyNotFound;

    void updateApprovalStatus(int id);

    Project getProposalsProject(int id);

    Collection<LoanProposal> getAllProposalsOfProject(int id);

    boolean isProposalAlreadyAccepted(int proposalId);

    LoanProposal getLoanProposal(int id);
}