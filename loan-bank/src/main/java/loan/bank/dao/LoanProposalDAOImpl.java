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
public class LoanProposalDAOImpl implements LoanProposalDAO {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    //Get
    @Override
    public Integer getNumberOfAcceptedProposals(int idBank) throws LoanProposalException.LoanProposalBankNotFoundException {
        try {
            Integer nrAcceptedProposals =
                    (Integer) em.createQuery("SELECT COUNT(proposal.proposalId) FROM LoanProposal proposal where " +
                                    "proposal.idBank=:idBank and proposal.isAccepted=:valid")
                            .setParameter("idBank", idBank)
                            .setParameter("valid", true).getSingleResult();
            System.out.println("NUMBER OF ACCEPTED PROPOSALSS =====> " + nrAcceptedProposals);
            return nrAcceptedProposals;
        } catch (NoResultException e) {
            throw new LoanProposalException.LoanProposalBankNotFoundException(idBank);
        }
    }

    //Post => Update
    @Override
    @Transactional
    public LoanProposal createLoanProposal(LoanProposal proposal) {
        em.persist(proposal);
        return proposal;
    }

    //Put => Create
    @Override
    @Transactional
    public LoanProposal updateLoanProposal(LoanProposal proposal) {
        em.createQuery("UPDATE LoanProposal p SET p.isAccepted=:isAccepted")
                .setParameter("isAccepted", true)
                .executeUpdate();
        return proposal;
    }

}