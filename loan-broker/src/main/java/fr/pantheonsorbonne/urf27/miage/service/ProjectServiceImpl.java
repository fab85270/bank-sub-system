package fr.pantheonsorbonne.urf27.miage.service;

import com.google.common.hash.Hashing;
import fr.pantheonsorbonne.urf27.miage.dao.AddressDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.BorrowerDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.ProjectDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.RealEstateDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.ProjectExceptions;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.RealEstate;

import java.nio.charset.StandardCharsets;
import java.util.Collection;

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


    public String getKeyForProject(Project project) {
        return Hashing.sha256().hashString(project.getBorrowerId().getBorrowerId() + ""
                + project.getRealEstateId().getRealEstateId(), StandardCharsets.UTF_8).toString();
    }

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
        project.setRequiredValue(requiredValue);
        project.setProposalDate(proposalDate);
        project.setExpirationDate(projectExpirationDate);
        project.setDurationMax(durationMax);
        project.setPublicKey(getKeyForProject(project));
      
        projectDAO.createProject(project);
        return project;
    }

    /* Méthode chargée d'obtenir un projet */
    @Override
    @Transactional
    public ProjectDTO getProject(int id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(em.find(Project.class, id), ProjectDTO.class);
    }

    @Override
    @Transactional
    public Project getProjectByPublicKey(String publicKey) throws ProjectExceptions.ProjectPublicKeyNotFound {
        return projectDAO.findProjectByPublicKey(publicKey);
    }

    /* Méthode chargée d'obtenir tous les projets */
    @Override
    @Transactional
    public Collection<Project> getAllProject() throws ProjectExceptions.ProjectsNotFound {
        return projectDAO.getAllProject();
    }

    /*Est utilise pour savoir si un mail a deja ete utilise pour la creation d un profil de borrower*/
    @Override
    @Transactional
    public Boolean mailUsed(String mail){
        return borrowerDAO.mailUsed(mail);
    }

    @Override
    @Transactional
    public Project findProject(int idProject) throws ProjectExceptions.ProjectNotFoundId {
        return projectDAO.findProject(idProject);
    }
}
