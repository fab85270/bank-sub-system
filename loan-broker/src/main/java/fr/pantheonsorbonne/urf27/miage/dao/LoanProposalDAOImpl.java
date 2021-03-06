package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.LoanProposalExceptions;
import fr.pantheonsorbonne.urf27.miage.exception.ProjectExceptions;
import fr.pantheonsorbonne.urf27.miage.model.LoanProposal;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.service.ProjectService;
import loan.commons.dto.LoanProposalDTO;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class LoanProposalDAOImpl implements LoanProposalDAO {

    @PersistenceContext
    EntityManager em;

    @Inject
    ProjectService projectService;

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
    /*
    Permet de créer un loanProposal à partir d'un DTO
     */
    public LoanProposal createLoanProposal(LoanProposalDTO proposalDTO) throws ProjectExceptions.ProjectPublicKeyNotFound {
        ModelMapper modelMapper = new ModelMapper();
        Project project = projectService.getProjectByPublicKey(proposalDTO.getProjectId().getPublicKey());

        LoanProposal proposal = modelMapper.map(proposalDTO, LoanProposal.class);
        proposal.setProjectId(project);

        em.persist(proposal);
        return proposal;
    }

    @Override
    @Transactional
    /*
    Passe le statut du projet à approuvé
     */
    public void updateApprovalStatus(int id) {
        em.createQuery("UPDATE LoanProposal lp SET lp.approvalStatus='APPROVED' WHERE lp.proposalId=:id")
                .setParameter("id", id)
                .executeUpdate();

        em.createQuery("UPDATE LoanProposal lp SET lp.approvalStatus='APPROVED' WHERE lp.proposalId=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    //Renvoie un projet selon son id
    public Project getProposalsProject(int id) {
        return em.find(LoanProposal.class, id).getProjectId();
    }

    @Override
    @Transactional
    //Renvoie tous les loanProposal liés à un projet
    public Collection<LoanProposal> getAllProposalsOfProject(int id) {
        return em.createQuery("SELECT lp.proposalId, lp.projectId, lp.approvalStatus FROM LoanProposal lp WHERE lp.projectId=:id")
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    @Transactional
    //Supprime un loanProposal selon son ID
    public void deleteLoanProposal(int id){
        em.createQuery("DELETE FROM LoanProposal lp where lp.proposalId=:id")
                .setParameter("id",id)
                .executeUpdate();
    }

    @Override
    @Transactional
    //Renvoie un LoanProposal selon son ID
    public LoanProposal getLoanProposal(int id) {
        return em.find(LoanProposal.class, id);
    }
}