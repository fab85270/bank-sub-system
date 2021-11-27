package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.model.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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

}
