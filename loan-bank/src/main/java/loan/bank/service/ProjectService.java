package loan.bank.service;

import loan.bank.exception.ProjectException;
import loan.commons.dto.ProjectDTO;

public interface ProjectService {

    ProjectDTO analyseProject(ProjectDTO projectDTO);
}
