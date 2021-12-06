package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.dao.LoanProposalDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.LoanProposalExceptions;
import fr.pantheonsorbonne.urf27.miage.exception.ProjectExceptions;
import fr.pantheonsorbonne.urf27.miage.model.ApprovalStatus;
import fr.pantheonsorbonne.urf27.miage.model.LoanProposal;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import loan.commons.dto.LoanProposalDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
    @Transactional
    public Collection<LoanProposal> getAllLoanProposal() throws LoanProposalExceptions.LoanProposalsNotFound {
        return LoanProposalDAO.getAllLoanProposal();
    }

    @Override
    @Transactional
    public LoanProposal createLoanProposal(LoanProposalDTO proposalDTO) throws ProjectExceptions.ProjectPublicKeyNotFound {
        return LoanProposalDAO.createLoanProposal(proposalDTO);
    }

    @Override
    @Transactional
    public void updateApprovalStatus(int proposalId) {
        LoanProposalDAO.updateApprovalStatus(proposalId);
    }

    @Override
    @Transactional
    public Project getProposalsProject(int proposalId) {
        return LoanProposalDAO.getProposalsProject(proposalId);
    }

    @Override
    @Transactional
    public Collection<LoanProposal> getAllProposalsOfProject(int projectId) {
        return LoanProposalDAO.getAllProposalsOfProject(projectId);
    }

    @Override
    @Transactional
    public boolean isProposalAlreadyAccepted(int proposalId) {
        int projectId = getProposalsProject(proposalId).getProjectId();
        System.out.println(projectId);
        Collection<LoanProposal> proposals = getAllProposalsOfProject(projectId);
        for (LoanProposal proposal : proposals) {
            if (proposal.getApprovalStatus().toString().equals(ApprovalStatus.APPROVED.toString()))
                return true;
        }
        return false;
    }

    @Override
    @Transactional
    public LoanProposal getLoanProposal(int id) {
        return LoanProposalDAO.getLoanProposal(id);
    }
}