package loan.bank.camel;

import loan.bank.service.ProjectServiceImpl;
import loan.commons.dto.ProjectDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ProjectGateway {

    @Inject
    ProjectServiceImpl projectService;

    public void isOk(ProjectDTO projectDTO) {
        System.out.println("HEEEREEE ====== ");
        System.out.println(projectService.isProjectEligible(projectDTO));
    }


}
