package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.dao.ProjectDAOImpl;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.RealEstate;
import loan.commons.dto.ProjectDTO;

import java.time.LocalDate;

public interface ProjectService {

    Project createProject(Borrower borrower, RealEstate realEstate, String projectDescription,
                          LocalDate proposalDate, LocalDate projectExpirationDate , double requiredValue, int durationMax);


    ProjectDTO getProject(int id);
}
