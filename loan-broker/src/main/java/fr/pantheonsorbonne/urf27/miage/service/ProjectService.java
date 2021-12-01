package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.RealEstate;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import loan.commons.dto.ProjectDTO;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Collection;

public interface ProjectService {

    Project createProject(Borrower borrower, RealEstate realEstate, String projectDescription,
                          LocalDate proposalDate, LocalDate projectExpirationDate , double requiredValue, int durationMax);

    Collection<Project> getAllProject() throws EntityNotFoundException;

    ProjectDTO getProject(int id);

    void changeIsDelivered(int projectID) throws EntityNotFoundException;

    Boolean mailUsed(String mail) throws EntityNotFoundException;

    Project findProject(int idProject) throws EntityNotFoundException;


}
