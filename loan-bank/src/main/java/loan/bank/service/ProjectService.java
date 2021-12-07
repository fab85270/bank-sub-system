package loan.bank.service;

import loan.bank.exception.LoanProposalException;
import loan.commons.dto.ProjectDTO;

import javax.enterprise.context.ApplicationScoped;

public interface ProjectService {

    boolean isProjectEligible(ProjectDTO projectDTO) throws LoanProposalException.LoanProposalRefusedException;

}
