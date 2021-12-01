package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.dao.AddressDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.ProjectSentBankDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.RealEstateDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@ApplicationScoped
public class ProjectSentBankServiceImpl implements ProjectSentBankService {

    @PersistenceContext
    EntityManager em;

    @Inject
    ProjectSentBankDAOImpl projectSentBankDAO;

    @Override
    public Boolean isSent(Bank b, Project p){
        return projectSentBankDAO.isSent(p,b);
    }

    @Override
    public void createSentBankProject(Project p,Bank b){
         projectSentBankDAO.createSentBankProject(p,b);
    }


}

