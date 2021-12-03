package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.dao.LoanProposalDAO;
import fr.pantheonsorbonne.urf27.miage.dao.LoanProposalDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.exception.LoanProposalExceptions;
import fr.pantheonsorbonne.urf27.miage.model.LoanProposal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@ApplicationScoped
public class LoanProposalServiceImpl implements LoanProposalService {

    @PersistenceContext
    EntityManager em;

    @Inject
    LoanProposalDAOImpl LoanProposalDAO;


    /*Renvoie l'entièreté des loanProposal
    * Permet pour un broker de voir les loan proposal qu'il a recu et lesquels choisir pour un client
    */
    @Override
    public Collection<LoanProposal> getAllLoanProposal() throws LoanProposalExceptions.LoanProposalsNotFound{
        return LoanProposalDAO.getAllLoanProposal();
    }
}