package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped

public class ProjectDAOImpl implements ProjectDAO{
    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    public Project getProjectById(int idProject) throws EntityNotFoundException{
        try{
            return (Project) em.createQuery("Select p from Project p where p.idProject=:idProject").setParameter("idProject",idProject).getSingleResult();
        }catch (NoResultException e){
            throw new EntityNotFoundException();
        }
    }
}
