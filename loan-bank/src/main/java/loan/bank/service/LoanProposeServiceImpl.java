package loan.bank.service;

import loan.bank.dao.LoanProposalDAO;
import loan.bank.dao.ProjectDAO;
import loan.bank.exception.LoanProposalException;
import loan.bank.exception.ProjectException;
import loan.bank.model.LoanProposal;
import loan.bank.model.Project;
import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LoanProposeServiceImpl implements LoanProposalService{

    @Inject
    @ConfigProperty(name = "bank.name")
    String bankName;

    @Inject
    TreatmentService treatmentService;




    @Override
    @Transactional
    public LoanProposalDTO emitProposal(ProjectDTO projectDTO) throws ProjectException.ExpiredProjectException, LoanProposalException.LoanProposalRefusedException {

        //Verify if project is expired
        if (projectDTO.getProjectExpirationDate().isBefore(LocalDate.now())) {
            throw new ProjectException.ExpiredProjectException();
        }
        LoanProposalDTO proposal = new LoanProposalDTO();

        proposal.setProjectDTO(projectDTO);
        LocalDate date = LocalDate.now();
        proposal.setProposalDate(date);
        proposal.setEndDate(date.plusMonths(3));
        proposal.setValid(false);
        proposal.setLoanAmount(projectDTO.getProjectRequiredValue());
        proposal.setDescription(projectDTO.getProjectDescription());
        proposal.setLoanDurationMonth(projectDTO.getProjectDurationMax());
        proposal.setNameBank(bankName);

        try {
            proposal=treatmentService.setLastInfos(proposal, projectDTO.getBorrowerDTO().getBirthdate(), projectDTO.getBorrowerDTO().getAnnualSalary(), projectDTO.getProjectRequiredValue(), projectDTO.getBorrowerDTO().getDebtRatio());
        } catch (LoanProposalException.LoanProposalRefusedException e) {
            e.printStackTrace();
        }

        return proposal;

    }

    @Override
    @Transactional
    public LoanProposalDTO validProposal(LoanProposalDTO loanProposalDTO) throws LoanProposalException.ExpiredLoanProposalException {

        //Verify if project is expired
        if (loanProposalDTO.getEndDate().isBefore(LocalDate.now())) {
            throw new LoanProposalException.ExpiredLoanProposalException();
        }

        loanProposalDTO.setValid(true);

        return loanProposalDTO;

    }
}
