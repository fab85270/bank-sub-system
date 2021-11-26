package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.dao.ProjectDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        Collection<Project> collection = new ArrayList<>();
        collection.add(new Project("coucou"));
        collection.add(new Project("ca va toi?"));
        return collection;
       // return projectDAO.getAllProject();
    }

    @Override
    public Project getProjectTest() throws EntityNotFoundException{
        Project project = new Project("coucou");
        return project;
    }

}

