package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.RealEstate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Instant;

@ApplicationScoped
public class ProjectDAOImpl implements ProjectDAO {

    @PersistenceContext
    EntityManager em;

    @Inject
    RealEstateDAOImpl realEstateDAO;

    @Override
    public Project createProject(Project project) {
        em.persist(project);
        return project;
    }

    @Override
    public Project createProject(RealEstate realEstate, String projectDescription, double requiredValue, int durationMax) {
        realEstateDAO.createRealEstate(realEstate);
//        Project project = new Project(projectDescription, requiredValue, durationMax);
        return null;
    }
}
