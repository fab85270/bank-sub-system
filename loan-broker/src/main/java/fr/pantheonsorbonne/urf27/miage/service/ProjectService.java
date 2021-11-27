package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import loan.commons.dto.ContratType;

import java.time.LocalDate;
import java.util.Collection;

public interface ProjectService {
    Project getProject(int projectId) throws EntityNotFoundException;

    Collection<Project> getAllProject() throws EntityNotFoundException;

    void createNewProjectClient(String description, LocalDate dateDebut,LocalDate dateFin, double sommeVoulu, ContratType contract);

    void changeIsDelivered(int projectID) throws EntityNotFoundException;
}
