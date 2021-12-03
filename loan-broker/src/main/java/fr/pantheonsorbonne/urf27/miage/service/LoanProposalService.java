package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.exception.LoanProposalExceptions;
import fr.pantheonsorbonne.urf27.miage.model.LoanProposal;

import java.util.Collection;

public interface LoanProposalService {
    Collection<LoanProposal> getAllLoanProposal() throws LoanProposalExceptions.LoanProposalsNotFound;
}