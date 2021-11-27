package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.dao.AddressDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.BorrowerDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.ProjectDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.RealEstateDAOImpl;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.RealEstate;

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
        realEstateDAO.createRealEstate(realEstate.getAddressId(), realEstate.getSurface(), realEstate.getConstructionYear(),
                realEstate.getPrice(), realEstate.getnumberOfRooms());
        System.out.println(borrower);
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

        projectDAO.createProject(project);
        return project;
    }
}
