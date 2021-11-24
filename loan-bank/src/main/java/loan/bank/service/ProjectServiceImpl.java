package loan.bank.service;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import loan.bank.dao.LoanProposalDAO;
import loan.bank.dao.ProjectDAO;
import loan.bank.exception.LoanProposalException;
import loan.bank.exception.ProjectException;

import loan.bank.model.LoanProposal;
import loan.bank.model.Project;
import loan.commons.dto.LoanProposalDTO;

@ApplicationScoped
public class ProjectServiceImpl implements ProjectService {


    @Inject
    ProjectDAO projectDAO;

    @Inject
    LoanProposalDAO loanProposalDAO;


    @Override
    @Transactional
    public void emitProposal(int projectId) throws ProjectException.ExpiredProjectException {

        Project project = null;
        try {
            project = projectDAO.findById(projectId);
        } catch (ProjectException.ProjectNotFoundException e) {
            e.printStackTrace();
        }

        //Verify if project is expired
        if (project.getExpirationDate().isBefore(Instant.now())) {
            throw new ProjectException.ExpiredProjectException(project.getProjectId());
        }
        LoanProposal proposal = new LoanProposal();
        proposal.setProjectId(project.getProjectId());

        proposal.setDateProposal(Instant.now());
        Instant date = Instant.now();
        proposal.setEndDate(date.plus(60, ChronoUnit.DAYS));
        proposal.setValid(false);
        proposal.setLoanAmount(project.getRequiredValue());
        proposal.setDescription(project.getProjectDescription());


        //Redefined after
        proposal.setInterestRate(0.00);
        proposal.setLoanDurationMonth(0);


        loanProposalDAO.post(proposal);

    }



    @Override
    @Transactional
    public void addInterestRateProposal(int proposalId, double rate) {


        LoanProposal proposal = null;
        try {
            proposal = loanProposalDAO.findbyId(proposalId);
        } catch (LoanProposalException.LoanProposalNotFoundException e) {
            e.printStackTrace();
        }

        proposal.setInterestRate(rate);

        loanProposalDAO.put(proposal);
    }

    @Override
    @Transactional
    public void addLoanDurationProposal(int proposalId, int duration) {

        LoanProposal proposal = null;
        try {
            proposal = loanProposalDAO.findbyId(proposalId);
        } catch (LoanProposalException.LoanProposalNotFoundException e) {
            e.printStackTrace();
        }
        proposal.setLoanDurationMonth(duration);

        loanProposalDAO.put(proposal);
    }

    @Override
    @Transactional
    public void validProposal(int proposalId, int duration){

        LoanProposal proposal = null;
        try {
            proposal = loanProposalDAO.findbyId(proposalId);
        } catch (LoanProposalException.LoanProposalNotFoundException e) {
            e.printStackTrace();
        }

        proposal.setValid(true);

        loanProposalDAO.put(proposal);
    }



}
