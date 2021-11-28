package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.model.Project;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

public interface ProjectDAO {

    public Project createProject(Project project);

    Collection<Project> getAllProject() throws EntityNotFoundException, fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;

}
