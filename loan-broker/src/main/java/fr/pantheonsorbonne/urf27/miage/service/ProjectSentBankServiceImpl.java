package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.dao.ProjectSentBankDAOImpl;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import loan.commons.dto.ProjectDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@ApplicationScoped
public class ProjectSentBankServiceImpl implements ProjectSentBankService {

    @PersistenceContext
    EntityManager em;

    @Inject
    ProjectSentBankDAOImpl projectSentBankDAO;

    /*Renvoie un boolen indiquant si le projet a deja ete envoye*/
    @Override
    @Transactional
    public Boolean isSent(Bank bank, Project project) {
        return projectSentBankDAO.isSent(project, bank);
    }

    /*Cree une nouvelle entree dans la bdd*/
    @Override
    @Transactional
    public void createSentBankProject(Project p, Bank b) {
        projectSentBankDAO.createSentBankProject(p, b);
    }

    @Override
    @Transactional
    public void updateStatusRejected(int idProject, int idBank) {
        projectSentBankDAO.updateStatusRejected(idProject, idBank);
    }

}

