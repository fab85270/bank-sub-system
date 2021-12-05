package loan.bank.camel;

import loan.bank.service.ProjectServiceImpl;
import loan.commons.dto.ProjectDTO;

import javax.inject.Inject;

public class ProjectGatewayImpl implements ProjectGateway{

    @Inject
    ProjectServiceImpl projectService;

    public ProjectDTO createProject(ProjectDTO projectDTO) {

        return projectService.analyseProject(projectDTO);
    }


}
