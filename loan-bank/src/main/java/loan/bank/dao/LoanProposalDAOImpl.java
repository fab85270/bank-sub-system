package loan.bank.dao;

import loan.bank.exception.LoanProposalException;
import loan.bank.model.ApprovalStatus;
import loan.bank.model.Borrower;
import loan.bank.model.LoanProposal;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class LoanProposalDAOImpl implements LoanProposalDAO {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    //Get
    @Override
    @Transactional
    public Integer getNumberOfAcceptedProposals(int idBank) throws LoanProposalException.LoanProposalBankNotFoundException {
        try {
            System.out.println("BANKIDDD === " + idBank);
            List nrAcceptedProposals =
                     em.createQuery("SELECT COUNT(proposal.proposalId) FROM LoanProposal proposal where " +
                                    "proposal.idBank=:idBank and proposal.approvalStatus='APPROVED'")
                            .setParameter("idBank", idBank)
                            .getResultList();


            System.out.println("NUMBER OF ACCEPTED PROPOSALSS =====> " + nrAcceptedProposals);
            return Integer.valueOf(String.valueOf(nrAcceptedProposals.get(0)));
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
        em.createQuery("UPDATE LoanProposal p SET p.approvalStatus=:status")
                .setParameter("status", ApprovalStatus.APPROVED)
                .executeUpdate();
        return proposal;
    }

}