package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.model.*;


public interface ProjectSentBankDAO {

    void createSentBankProject(Project project, Bank bank);

    boolean isSent(Project idProject, Bank idBank);


}