package loan.bank.dao;

import loan.bank.model.LoanProposal;
import loan.bank.model.Project;
import loan.commons.dto.ProjectDTO;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class ProjectDAOImpl implements ProjectDAO {

    @PersistenceContext
    EntityManager em;

    @Inject
    BorrowerDAO borrowerDAO;

    @Override
    @Transactional
    public Project createProject(ProjectDTO projectDTO) {

        borrowerDAO.createBorrower(projectDTO.getBorrowerId());
        ModelMapper modelMapper = new ModelMapper();
        Project project = modelMapper.map(projectDTO, Project.class);

        em.persist(project);
        return project;
    }

    /*  Renvoie tous les projets présents dans la BDD */
    @Override
    @Transactional
    public Collection<Project> getAllProject() {
        return (Collection<Project>) em.createQuery("Select p from Project p").getResultList();
    }

    /*Permet de trouver un projet avec son ID*/
    @Override
    @Transactional
    public Project findProject(int idProject) {
        return em.find(Project.class, idProject);
    }

}