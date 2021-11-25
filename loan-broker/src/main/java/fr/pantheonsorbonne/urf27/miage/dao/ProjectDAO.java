package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import java.util.Collection;

public interface ProjectDAO {

    Project getProjectById(int id) throws EntityNotFoundException;

    Collection<Project> getAllProject() throws EntityNotFoundException;
}
