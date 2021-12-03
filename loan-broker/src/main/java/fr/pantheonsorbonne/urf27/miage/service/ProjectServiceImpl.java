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
import jdk.jfr.StackTrace;

import loan.commons.dto.ProjectDTO;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;

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

    /* Méthode chargée d'obtenir un projet */
    @Override
    @Transactional
    public ProjectDTO getProject(int id) {
        System.out.println(em.find(Project.class, id));
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(em.find(Project.class, id), ProjectDTO.class);
    }

    /* Méthode chargée d'obtenir tous les projets */
    @Override
    public Collection<Project> getAllProject() throws EntityNotFoundException {
        return projectDAO.getAllProject();
    }

    /*Change la valeur de isDelivered permettant de savoir si le projet a ete envoye*/
    @Override
    @Transactional
    public void changeIsDelivered(int projectID) throws EntityNotFoundException{
        /*Appel d'une méthode DAO pour effectuer les modifications (update) sur le projet client envoyé à la banque */
        projectDAO.changeIsDelivered(projectID);
    }

    /*Est utilise pour savoir si un mail a deja ete utilise pour la creation d un profil de borrower*/
    @Override
    @Transactional
    public Boolean mailUsed(String mail) throws EntityNotFoundException{
        return borrowerDAO.mailUsed(mail);

    }


    @Override
    public Project findProject(int idProject) throws EntityNotFoundException {
        return projectDAO.findProject(idProject);
    }
}
