package loan.bank.service;

import loan.commons.dto.ProjectDTO;

public interface ProjectService {

    boolean isProjectEligible(ProjectDTO projectDTO);

}
