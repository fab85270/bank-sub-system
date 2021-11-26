package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Collection;

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
    @Override
    public Collection<Project> getAllProject() throws EntityNotFoundException{
        try{
            return (Collection<Project>) em.createQuery("Select p from Project p ").getResultList();
        }catch (NoResultException e){
            throw new EntityNotFoundException();
        }
    }

    @Override
    @Transactional
    /*Méthode pour tester l'affichage des différents projets*/
    public Project createNewProject(){

        Instant date = Instant.now();
         em.createQuery("DELETE from Project ").executeUpdate();
        Project project = new Project("coucou",date,date,653.87);
        Project project1 = new Project("Fabinou",date,date,87.98);
        em.persist(project);
        em.persist(project1);
        return project;
    }
}
