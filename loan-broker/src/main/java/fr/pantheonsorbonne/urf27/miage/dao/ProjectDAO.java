package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.RealEstate;

public interface ProjectDAO {

    public Project createProject(Project project);

    public Project createProject(RealEstate realEstate, String projectDescription, double requiredValue, int durationMax);
}
