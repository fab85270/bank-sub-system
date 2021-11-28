package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.dao.AddressDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.BorrowerDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.ProjectDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.RealEstateDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.RealEstate;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class ProjectServiceImpl implements ProjectService {

    @PersistenceContext
    EntityManager em;

    @Inject
    RealEstateDAOImpl realEstateDAO;

    @Inject
    AddressDAOImpl addressDAO;

    @Inject
    ProjectDAOImpl projectDAO;

    @Inject
    BorrowerDAOImpl borrowerDAO;

    @Override
    @Transactional
    public Project createProject(Borrower borrower, RealEstate realEstate, String projectDescription,
                                 LocalDate proposalDate, LocalDate projectExpirationDate , double requiredValue, int durationMax) {
        Project project = new Project();
        addressDAO.createAddress(realEstate.getAddressId());
        realEstate.setAddressId(realEstate.getAddressId());
        realEstateDAO.createRealEstate(realEstate);
        addressDAO.createAddress(borrower.getAddressId());
        borrower.setAddressId(borrower.getAddressId());
        borrowerDAO.createNewBorrower(borrower);
        project.setBorrowerId(borrower);
        project.setRealEstateId(realEstate);
        project.setProjectDescription(projectDescription);
        project.setrequiredValue(requiredValue);
        project.setProposalDate(proposalDate);
        project.setExpirationDate(projectExpirationDate);
        project.setDurationMax(durationMax);

        project.setDelivered(false);

        projectDAO.createProject(project);
        return project;
    }

    /* Méthode chargée d'obtenir tous les projets */

    @Override
    public Collection<Project> getAllProject() throws EntityNotFoundException {
        return projectDAO.getAllProject();
    }

    @Override
    @Transactional
    public void changeIsDelivered(int projectID) throws EntityNotFoundException{
        /*Appel d'une méthode DAO pour effectuer les modifications (update) sur le projet client envoyé à la banque */
        System.out.println("Essai bis : "+projectID);
        projectDAO.changeIsDelivered(projectID);
    }
}
