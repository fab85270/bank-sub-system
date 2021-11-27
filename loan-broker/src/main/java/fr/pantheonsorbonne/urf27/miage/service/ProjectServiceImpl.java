package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.dao.ProjectDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Collection;
import java.util.ArrayList;

@ApplicationScoped
public class ProjectServiceImpl implements ProjectService {
    @PersistenceContext
    EntityManager em;

    @Inject
    ProjectDAOImpl projectDAO ;

    @Override
    public Project getProject(int projectId) throws EntityNotFoundException{
        System.out.println(projectDAO.getProjectById(projectId).getProjectDescription());
        return projectDAO.getProjectById(projectId);
    }

    @Override
    public Collection<Project> getAllProject() throws EntityNotFoundException{

        /* Phase de tests seulement */

    /* Création d'un rapide base de données */


        Project e = projectDAO.createNewProject();

        return projectDAO.getAllProject();
    }

    @Override
    public Project getProjectTest() throws EntityNotFoundException{
        Project project = new Project("coucou");
        return project;
    }

    @Override
    @Transactional
    public Project createNewProjectClient(){
        return null;
    }

    @Override
    @Transactional
    public void changeIsDelivered(int projectID) throws EntityNotFoundException{
        /*Appel d'une méthode DAO pour effectuer les modifications (update) sur le projet client envoyé à la banque */
        projectDAO.changeIsDelivered(projectID);
    }

}

