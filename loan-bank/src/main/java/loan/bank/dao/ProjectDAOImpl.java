package loan.bank.dao;

import loan.bank.exception.ProjectException;
import loan.bank.model.LoanProposal;
import loan.bank.model.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;



@ApplicationScoped
public class ProjectDAOImpl implements ProjectDAO {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    //Get
    @Override
    public Project findById(int id) throws ProjectException.ProjectNotFoundException {
        try {
            Project project = (Project) em.createQuery("Select project from Project project where project.projectId=:projectId").setParameter("projectId", id).getSingleResult();
            return project;
        } catch (NoResultException e) {
            throw new ProjectException.ProjectNotFoundException(id);
        }
    }

    //Post
    @Override
    @Transactional
    public Project post(Project project) {
        em.persist(project);
        return project;
    }

    //Post
    @Override
    @Transactional
    public Project put(Project project) {
        em.merge(project);
        return project;
    }

}