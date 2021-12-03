package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.ProjectExceptions;
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

    /*
    Cree un nouveau projet à partir de l'entite projet
     */
    @Override
    @Transactional
    public Project createProject(Project project) {

        em.persist(project);
        return project;
    }

    /*
    Renvoie tous les projets présents dans la BDD
     */
    @Override
    public Collection<Project> getAllProject() throws ProjectExceptions.ProjectsNotFound {
        try{
            return (Collection<Project>) em.createQuery("Select p from Project p").getResultList();
        }catch (NoResultException e){
            throw new ProjectExceptions.ProjectsNotFound();
        }
    }


    /*
    Permet de trouver un projet avec son ID
     */
    @Override
    public Project findProject(int idProject) throws ProjectExceptions.ProjectNotFoundId {
        try {
            Project p = (Project) em.createQuery("Select p from Project p where p.projectId=:idProject").setParameter("idProject", idProject).getSingleResult();
            return p;
        } catch (NoResultException e) {
            throw new ProjectExceptions.ProjectNotFoundId(idProject);
        }
    }

}