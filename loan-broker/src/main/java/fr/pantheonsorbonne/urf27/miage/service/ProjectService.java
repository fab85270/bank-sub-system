package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import java.util.Collection;

public interface ProjectService {
    Project getProject(int projectId) throws EntityNotFoundException;
    Collection<Project> getAllProject() throws EntityNotFoundException;
}
