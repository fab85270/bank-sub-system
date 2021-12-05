package loan.bank.service;

import loan.bank.dao.LoanProposalDAO;
import loan.bank.exception.LoanProposalException;
import loan.bank.model.LoanProposal;
import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;

public class LoanProposalServiceImpl implements LoanProposalService {

    @Inject
    @ConfigProperty(name = "bank.id")
    int bankId;

    @Inject
    LoanProposalDAO loanProposalDAO;

    @Inject
    @ConfigProperty(name = "loan.bank.interestRate15Years")
    double interestRate15Years;

    @Inject
    @ConfigProperty(name = "loan.bank.interestRate20Years")
    double interestRate20Years;

    @Inject
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
    public LoanProposalDTO emitProposal(ProjectDTO projectDTO) throws LoanProposalException.LoanProposalBankNotFoundException {

        LoanProposalDTO proposal = new LoanProposalDTO();

        proposal.setProjectDTO(projectDTO);
        LocalDate date = LocalDate.now();
        proposal.setProposalDate(date);
        proposal.setEndDate(date.plusMonths(maxProposalDuration));
        proposal.setAccepted(false);
        proposal.setLoanAmount(projectDTO.getRequiredValue());
        proposal.setDescription(projectDTO.getProjectDescription());
        proposal.setLoanDurationMonth(projectDTO.getDurationMax());
        proposal.setInterestRate(getInterestRate(projectDTO));
        proposal.setIdBank(bankId);

        return proposal;
    }

    @Override
    public void saveProposal(LoanProposalDTO proposalDTO) {
        ModelMapper modelMapper = new ModelMapper();
        LoanProposal proposal = modelMapper.map(proposalDTO, LoanProposal.class);
        loanProposalDAO.createLoanProposal(proposal);
    }

    public double getInterestRate(ProjectDTO project) throws LoanProposalException.LoanProposalBankNotFoundException {
        double rate = getDurationInterestRate(project);
        int nrAcceptedProposals = loanProposalDAO.getNumberOfAcceptedProposals(bankId);

        switch (nrAcceptedProposals) {
            case 0:
                return rate;
            case 1:
                return rate - 0.05;
            case 2:
            case 3:
                return rate - 0.1;
            default:
                return rate - 0.15;

        }
    }

    private double getDurationInterestRate(ProjectDTO project) {
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
