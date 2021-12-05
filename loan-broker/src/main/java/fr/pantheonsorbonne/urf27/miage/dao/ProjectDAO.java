package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.ProjectExceptions;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import java.util.Collection;

public interface ProjectDAO {

    Project createProject(Project project);

    Collection<Object> getAllProject() throws ProjectExceptions.ProjectsNotFound;

    Project findProject(int idProject) throws ProjectExceptions.ProjectNotFoundId;

    Project findProjectByPublicKey(String key) throws ProjectExceptions.ProjectPublicKeyNotFound;
}