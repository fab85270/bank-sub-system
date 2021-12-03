package loan.bank.service;

import loan.bank.dao.LoanProposalDAO;
import loan.bank.dao.ProjectDAO;
import loan.bank.exception.LoanProposalException;
import loan.bank.exception.ProjectException;
import loan.bank.model.LoanProposal;
import loan.bank.model.Project;
import loan.commons.dto.BorrowerDTO;
import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

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

    @Inject
    ProjectDAO projectDAO;

    @Inject
    LoanProposalDAO loanProposalDAO;

    @Inject
    @ConfigProperty(name = "bank.legal.debtRatio")
    double debtRatio;

    @Inject
    @ConfigProperty(name = "bank.requiredSalary")
    double requireSalary;




    @Override
    @Transactional
    public LoanProposalDTO emitProposal(ProjectDTO projectDTO) throws ProjectException.ExpiredProjectException{

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
        } catch (LoanProposalException.LoanProposalRefusedException | LoanProposalException.LoanProposalBankNotFoundException e) {
            e.printStackTrace();
        }

        return proposal;

    }

    @Override
    public void saveProject(ProjectDTO projectDTO) throws ProjectException.ExpiredProjectException {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Project project = modelMapper.map(projectDTO, Project.class);
        projectDAO.post(project);

    }

    @Override
    public void saveProposal(LoanProposalDTO proposalDTO) throws ProjectException.ExpiredProjectException {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        LoanProposal loanProposal = modelMapper.map(proposalDTO, LoanProposal.class);
        loanProposalDAO.post(loanProposal);
    }

    @Override
    public boolean isValidProject(ProjectDTO projectDTO) {

        BorrowerDTO borrowerDTO = projectDTO.getBorrowerDTO();
        int age = LocalDate.now().getYear() - borrowerDTO.getBirthdate().getYear();

        if (isBetween(age, 18, 65) && sufficientSalary(borrowerDTO.getAnnualSalary(), projectDTO.getProjectRequiredValue()) && borrowerDTO.getDebtRatio() <= debtRatio) {
            return true;
        }
        return false;
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

    public boolean sufficientSalary(double salary, double amount) {
        if (salary >= requireSalary * amount) {
            return true;
        }
        return false;
    }

    public boolean isBetween(int x, int lower, int upper) {

        return lower <= x && x <= upper;
    }
}
