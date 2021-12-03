package fr.pantheonsorbonne.urf27.miage.dao;

import com.mysql.cj.xdevapi.AbstractDataResult;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.exception.LoanProposalExceptions;
import fr.pantheonsorbonne.urf27.miage.model.Address;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.LoanProposal;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class LoanProposalDAOImpl implements LoanProposalDAO{
    @PersistenceContext
    EntityManager em;

    @Override
    public Collection<LoanProposal> getAllLoanProposal() throws LoanProposalExceptions.LoanProposalsNotFound{
        try{
            Collection<LoanProposal> test = (Collection<LoanProposal>) em.createQuery("select l from LoanProposal l").getResultList();
            //System.out.println(test);
            return test;
        }catch (NoResultException e){
            throw new LoanProposalExceptions.LoanProposalsNotFound();
            //
        }
    }
}