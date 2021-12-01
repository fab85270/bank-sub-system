package loan.bank.dao;

import loan.bank.exception.LoanProposalException;
import loan.bank.model.Borrower;
import loan.bank.model.LoanProposal;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class LoanProposalDOAImpl implements LoanProposalDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;

    //Get
    @Override
    public LoanProposal findMatchingLoanProposal(int id) throws LoanProposalException.LoanProposalNotFoundException {
        try {
            LoanProposal l = (LoanProposal) em.createQuery("SELECT b FROM LoanProposal b where b.proposalId=:id").setParameter("id",id).getSingleResult();
            return l;
        } catch (NoResultException e) {
            throw new LoanProposalException.LoanProposalNotFoundException(id);
        }
    }

    //Post => Update
    @Override
    @Transactional
    public LoanProposal post(LoanProposal proposal) {
        em.persist(proposal);
        return proposal;
    }

    //Put => Create
    @Override
    @Transactional
    public LoanProposal put(LoanProposal proposal) {
        em.merge(proposal);
        return proposal;
    }

}