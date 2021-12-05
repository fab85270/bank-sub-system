package loan.bank.camel;

import loan.bank.exception.LoanProposalException;
import loan.commons.dto.ProjectDTO;

public interface ProjectGateway {

    boolean isProjectEligible(ProjectDTO projectDTO) throws LoanProposalException.LoanProposalRefusedException;
}
