package loan.bank.service;


import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import loan.bank.exception.ProjectException;

import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectDTO;

@ApplicationScoped
public class ProjectServiceImpl implements ProjectService {


    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void emitProposal(int projectId) throws ProjectException.ExpiredProjectException {

        ProjectDTO project = em.find(ProjectDTO.class, projectId);

        //Verify if project is expired
        if (project.getExpirationDate().isBefore(Instant.now())) {
            throw new ProjectException.ExpiredProjectException(project.getProjectId());
        }
        LoanProposalDTO proposal = new LoanProposalDTO();
        proposal.setProjectId(project.getProjectId());
        proposal.setBrokerId(project.getBrokerId());

        proposal.setProposalDate(Instant.now());
        Instant date = Instant.now();
        proposal.setEndDate(date.plus(60, ChronoUnit.DAYS));
        proposal.setValid(false);
        proposal.setLoanAmount(project.getRequiredValue());
        proposal.setDescription(project.getProjectDescription());


        //Redefined after
        proposal.setInterestRate(0.00);
        proposal.setLoanDurationMonth(0);


        em.persist(proposal);

    }



    @Override
    @Transactional
    public void addInterestRateProposal(int proposalId, double rate) {

        LoanProposalDTO proposal = em.find(LoanProposalDTO.class, proposalId);

        proposal.setInterestRate(rate);

        em.persist(proposal);
    }

    @Override
    @Transactional
    public void addLoanDurationProposal(int proposalId, int duration) {

        LoanProposalDTO proposal = em.find(LoanProposalDTO.class, proposalId);
        proposal.setLoanDurationMonth(duration);

        em.persist(proposal);
    }

    @Override
    @Transactional
    public void validProposal(int proposalId, int duration){

        LoanProposalDTO proposal = em.find(LoanProposalDTO.class, proposalId);
        proposal.setValid(true);

        em.persist(proposal);
    }



}
