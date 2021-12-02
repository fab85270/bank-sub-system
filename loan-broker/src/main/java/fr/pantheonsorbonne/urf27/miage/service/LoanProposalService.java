package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.LoanProposal;

import java.util.Collection;

public interface LoanProposalService {
    Collection<LoanProposal> getAllLoanProposal(int idDuProjet) throws EntityNotFoundException;
}
