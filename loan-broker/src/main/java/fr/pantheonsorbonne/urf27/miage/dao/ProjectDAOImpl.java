package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class ProjectDAOImpl implements ProjectDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Project createProject(Project project) {

        em.persist(project);
        return project;
    }

    @Override
    public Collection<Project> getAllProject() throws EntityNotFoundException {
        try{
            return (Collection<Project>) em.createQuery("Select p from Project p Where p.isDelivered=false").getResultList();
        }catch (NoResultException e){
            throw new EntityNotFoundException();
        }
    }

}
