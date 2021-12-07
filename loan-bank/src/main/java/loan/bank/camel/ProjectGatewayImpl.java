package loan.bank.camel;

import loan.bank.exception.LoanProposalException;
import loan.bank.exception.ProjectException;
import loan.bank.service.LoanProposalService;
import loan.bank.service.ProjectService;
import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ProjectGatewayImpl implements ProjectGateway {

    @Inject
    ProjectService projectService;

    @Inject
    LoanProposalService loanProposalService;

    //Calcule l'éligibilité du projet
    @Override
    public boolean isProjectEligible(ProjectDTO projectDTO) throws LoanProposalException.LoanProposalRefusedException {
        return projectService.isProjectEligible(projectDTO);
    }

    //Crée un loanProposal à partir d'un projectDTO reçu du broker
    @Override
    public LoanProposalDTO createLoanProposal(ProjectDTO projectDTO) throws ProjectException.ExpiredProjectException, LoanProposalException.LoanProposalRefusedException, LoanProposalException.LoanProposalBankNotFoundException {
        if (isProjectEligible(projectDTO))
            return loanProposalService.createProposal(projectDTO);

        throw new LoanProposalException.LoanProposalRefusedException(projectDTO.getProjectDescription());
    }


}
