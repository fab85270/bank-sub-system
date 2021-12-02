package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.dao.LoanProposalDAO;
import fr.pantheonsorbonne.urf27.miage.dao.LoanProposalDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
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


    @Override
    public Collection<LoanProposal> getAllLoanProposal() throws EntityNotFoundException{
        return LoanProposalDAO.getAllLoanProposal();
    }
}