package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.ProjectExceptions;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import java.util.Collection;

public interface ProjectDAO {

    Project createProject(Project project);

    Collection<Project> getAllProject() throws ProjectExceptions.ProjectsNotFound;

    void changeIsDelivered(int projectID) throws EntityNotFoundException, fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;

    Project findProject(int idProject) throws ProjectExceptions.ProjectNotFoundId;

}