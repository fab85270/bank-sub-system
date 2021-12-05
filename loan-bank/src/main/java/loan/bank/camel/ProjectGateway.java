package loan.bank.camel;

import loan.commons.dto.ProjectDTO;

public interface ProjectGateway {

    ProjectDTO createProject(ProjectDTO projectDTO);
}
