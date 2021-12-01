package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;

public interface ProjectSentBankService {

    Boolean isSent(Bank b, Project p);

    void createSentBankProject(Project p,Bank b);
}
