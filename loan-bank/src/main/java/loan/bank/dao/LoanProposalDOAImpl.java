package loan.bank.dao;

import loan.bank.exception.LoanProposalException;
import loan.bank.model.Borrower;
import loan.bank.model.LoanProposal;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class LoanProposalDOAImpl implements LoanProposalDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;

    //Get
    @Override
    public Collection<LoanProposal> findMatchingPastLoanProposalWithBank(String idBank) throws LoanProposalException.LoanProposalBankNotFoundException {
        try {
            LoanProposal l = (LoanProposal) em.createQuery("SELECT b FROM LoanProposal b where b.proposalId=:bankName and b.isValid=:valid").setParameter("bankName",idBank).setParameter("valid",true).getResultList();
            return (Collection<LoanProposal>) l;
        } catch (NoResultException e) {
            throw new LoanProposalException.LoanProposalBankNotFoundException(idBank);
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