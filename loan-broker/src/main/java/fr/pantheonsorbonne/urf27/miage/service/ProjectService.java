package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.dao.ProjectDAOImpl;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.RealEstate;

import javax.inject.Inject;

public interface ProjectService {

    Project createProject(RealEstate realEstate, String projectDescription, double requiredValue, int durationMax);


}
