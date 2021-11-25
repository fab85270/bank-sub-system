package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.dao.ProjectDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

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
        return projectDAO.getAllProject();
    }

}

