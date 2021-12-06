package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.LoanProposalExceptions;
import fr.pantheonsorbonne.urf27.miage.model.LoanProposal;
import jdk.jfr.StackTrace;
import loan.commons.dto.LoanProposalDTO;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class LoanProposalDAOImpl implements LoanProposalDAO {

    @PersistenceContext
    EntityManager em;

    /*
    Renvoie tous les loan proposals de la bdd
     */
    @Override
    @Transactional
    public Collection<LoanProposal> getAllLoanProposal() throws LoanProposalExceptions.LoanProposalsNotFound {
        try {
            Collection<LoanProposal> test = (Collection<LoanProposal>) em.createQuery("select l from LoanProposal l").getResultList();
            //System.out.println(test);
            return test;
        } catch (NoResultException e) {
            throw new LoanProposalExceptions.LoanProposalsNotFound();
            //
        }
    }

    @Override
    @Transactional
    public LoanProposal createLoanProposal(LoanProposalDTO proposalDTO) {
        ModelMapper modelMapper = new ModelMapper();
        LoanProposal proposal = modelMapper.map(proposalDTO, LoanProposal.class);
        em.persist(proposal);
        return proposal;
    }

    @Override
    @Transactional
    public void updateApprovalStatus(int id) {
        em.createQuery("UPDATE LoanProposal lp SET lp.approvalStatus='APPROVED' WHERE lp.proposalId=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}