package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;


public interface ProjectSentBankDAO {

    void createSentBankProject(Project project, Bank bank);

    boolean isSent(Project idProject, Bank idBank);

    void updateStatusRejected(int idProject, int idBank);

}