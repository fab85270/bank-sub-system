package loan.bank.service;

import loan.bank.exception.LoanProposalException;
import loan.commons.dto.ApprovalStatus;
import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.time.LocalDate;

@ApplicationScoped
public class LoanProposalServiceImpl implements LoanProposalService {

    @ConfigProperty(name = "loan.bank.id")
    int bankId;

    @ConfigProperty(name = "loan.bank.interestRate15Years")
    double interestRate15Years;

    @ConfigProperty(name = "loan.bank.interestRate20Years")
    double interestRate20Years;

    @ConfigProperty(name = "loan.bank.interestRate25Years")
    double interestRate25Years;

    @ConfigProperty(name = "loan.bank.creditUnder15Years")
    int creditUnder15Years;

    @ConfigProperty(name = "loan.bank.creditUnder20Years")
    int creditUnder20Years;

    @ConfigProperty(name = "loan.bank.maxProposalDuration")
    int maxProposalDuration;

    @Override
    @Transactional
    //Crée le loanProposal selon un project DTO reçue
    public LoanProposalDTO createProposal(ProjectDTO projectDTO) throws LoanProposalException.LoanProposalBankNotFoundException {

        LoanProposalDTO proposal = new LoanProposalDTO();

        proposal.setProjectId(projectDTO);
        LocalDate date = LocalDate.now();
        proposal.setProposalDate(date);
        proposal.setEndDate(date.plusMonths(maxProposalDuration));
        proposal.setApprovalStatus(ApprovalStatus.PENDING);
        proposal.setLoanAmount(projectDTO.getRequiredValue());
        proposal.setDescription(projectDTO.getProjectDescription());
        proposal.setLoanDurationMonth(projectDTO.getDurationMax());
        proposal.setInterestRate(getInterestRate(projectDTO));
        proposal.setIdBank(bankId);

        return proposal;
    }

    //Calcule le taux d'interet selon les règles métiers
    private double getInterestRate(ProjectDTO project) {
        int duration = project.getDurationMax();
        if (duration <= creditUnder15Years) {
            return interestRate15Years;
        } else if (duration <= creditUnder20Years) {
            return interestRate20Years;
        } else {
            return interestRate25Years;
        }

    }

}
