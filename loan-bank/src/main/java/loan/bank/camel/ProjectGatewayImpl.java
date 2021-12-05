package loan.bank.camel;

import loan.bank.exception.LoanProposalException;
import loan.bank.service.ProjectServiceImpl;
import loan.commons.dto.ProjectDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ProjectGatewayImpl implements ProjectGateway {

    @Inject
    ProjectServiceImpl projectService;

    @Override
    public boolean isProjectEligible(ProjectDTO projectDTO) throws LoanProposalException.LoanProposalRefusedException {
        return projectService.isProjectEligible(projectDTO);
    }


}
