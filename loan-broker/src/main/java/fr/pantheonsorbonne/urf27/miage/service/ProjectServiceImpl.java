package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.dao.AddressDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.ProjectDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.RealEstateDAOImpl;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.RealEstate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class ProjectServiceImpl implements ProjectService {

    @PersistenceContext
    EntityManager em;

    @Inject
    RealEstateDAOImpl realEstateDAO;

    @Inject
    AddressDAOImpl addressDAO;

    @Override
    @Transactional
    public Project createProject(RealEstate realEstate, String projectDescription, double requiredValue, int durationMax) {
        Project project = new Project();
        addressDAO.createAddress(realEstate.getAddressId());
        realEstate.setAddressId(realEstate.getAddressId());
        realEstateDAO.createRealEstate(realEstate.getAddressId(), realEstate.getSurface(), realEstate.getConstructionYear(),
                realEstate.getPrice(), realEstate.getNumberOfParts());
        project.setRealEstateId(realEstate);
        project.setProjectDescription(projectDescription);
        project.setrequiredValue(requiredValue);
        project.setProposalDate(Instant.now());
        project.setExpirationDate(Instant.now().plus(60, ChronoUnit.DAYS));
        project.setDurationMax(durationMax);

        em.persist(project);
        return project;
    }
}
