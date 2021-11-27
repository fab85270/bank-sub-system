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
import java.time.LocalDate;
import java.util.Collection;
import java.util.ArrayList;
import loan.commons.dto.ContratType;

@ApplicationScoped
public class ProjectServiceImpl implements ProjectService {
    @PersistenceContext
    EntityManager em;

    @Inject
    ProjectDAOImpl projectDAO ;

    @Override
    public Project getProject(int projectId) throws EntityNotFoundException{
        return projectDAO.getProjectById(projectId);
    }

    @Override
    public Collection<Project> getAllProject() throws EntityNotFoundException{
        return projectDAO.getAllProject();
    }



    @Override
    @Transactional
    public void createNewProjectClient(String description, LocalDate dateDebut, LocalDate dateFin, double sommeVoulu, ContratType contrat){
        projectDAO.createNewProject(description,dateDebut,dateFin,sommeVoulu,contrat);
    }

    @Override
    @Transactional
    public void changeIsDelivered(int projectID) throws EntityNotFoundException{
        /*Appel d'une méthode DAO pour effectuer les modifications (update) sur le projet client envoyé à la banque */
        System.out.println("Essai bis : "+projectID);
        projectDAO.changeIsDelivered(projectID);
    }

}

