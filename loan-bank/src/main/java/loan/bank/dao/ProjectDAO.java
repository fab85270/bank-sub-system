package loan.bank.dao;
import loan.bank.model.Project;
import loan.commons.dto.ProjectDTO;

import java.util.Collection;

public interface ProjectDAO {

    Project createProject(ProjectDTO project);

    Collection<Project> getAllProject();

    Project findProject(int idProject);

}