package loan.bank.service;

import loan.bank.exception.LoanProposalException;
import loan.commons.dto.ProjectDTO;

public interface ProjectService {

    boolean isProjectEligible(ProjectDTO projectDTO) throws LoanProposalException.LoanProposalRefusedException;

}
