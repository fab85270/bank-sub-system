package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.LoanProposal;

import java.util.Collection;

public interface LoanProposalDAO {
    Collection<LoanProposal> getAllLoanProposal(int idProj) throws EntityNotFoundException;

}
