package loan.bank.dao;

import loan.bank.exception.LoanProposalException;
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
    public LoanProposal findbyId(int id) throws LoanProposalException.LoanProposalNotFoundException {
        try {
            LoanProposal proposal = (LoanProposal) em.createQuery("Select proposal from LoanProposal proposal where proposal.id=:id").setParameter("id", id).getSingleResult();
            return proposal;
        } catch (NoResultException e) {
            throw new LoanProposalException.LoanProposalNotFoundException(id);
        }
    }

    //Post
    @Override
    @Transactional
    public LoanProposal post(LoanProposal proposal) {
        em.persist(proposal);
        return proposal;
    }

    //Post
    @Override
    @Transactional
    public LoanProposal put(LoanProposal proposal) {
        em.merge(proposal);
        return proposal;
    }

}