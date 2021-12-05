package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.exception.ProjectExceptions;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.RealEstate;
import loan.commons.dto.ProjectDTO;

import java.time.LocalDate;
import java.util.Collection;

public interface ProjectService {

    Project createProject(Borrower borrower, RealEstate realEstate, String projectDescription,
                          LocalDate proposalDate, LocalDate projectExpirationDate , double requiredValue, int durationMax);

    Collection<Project> getAllProject() throws ProjectExceptions.ProjectsNotFound;

    Collection<Object> getAllProjectSentToBank() throws ProjectExceptions.ProjectsNotFound;

    ProjectDTO getProject(int id);


    Boolean mailUsed(String mail);

    Project findProject(int idProject) throws ProjectExceptions.ProjectNotFoundId;

    Project getProjectByPublicKey(String publicKey) throws ProjectExceptions.ProjectPublicKeyNotFound;
}
