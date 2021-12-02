package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import loan.commons.dto.ContratType;

import java.time.LocalDate;
import java.util.Collection;

public interface ProjectDAO {

    Project getProjectById(int id) throws EntityNotFoundException;

    Collection<Project> getAllProject() throws EntityNotFoundException;

    Project createNewProject(String description, LocalDate dateDebut, LocalDate dateFin, double sommeVoulu, ContratType contrat);

    void changeIsDelivered(int projectID) throws EntityNotFoundException;
}
