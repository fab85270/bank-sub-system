package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import loan.commons.dto.ProjectDTO;

public interface ProjectSentBankService {

    Boolean isSent(Bank b, Project p);

    void createSentBankProject(Project p, Bank b);

    void updateStatusRejected(int idProject, int idBank);

    void updateStatusApproved(int idProject, int idBank);
}
