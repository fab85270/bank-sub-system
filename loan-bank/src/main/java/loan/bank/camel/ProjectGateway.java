package loan.bank.camel;

import loan.bank.exception.LoanProposalException;
import loan.bank.exception.ProjectException;
import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectDTO;

public interface ProjectGateway {

    ProjectDTO isProjectEligible(ProjectDTO projectDTO) throws LoanProposalException.LoanProposalRefusedException;

    LoanProposalDTO createLoanProposal(ProjectDTO projectDTO) throws ProjectException.ExpiredProjectException, LoanProposalException.LoanProposalRefusedException, LoanProposalException.LoanProposalBankNotFoundException;
}
