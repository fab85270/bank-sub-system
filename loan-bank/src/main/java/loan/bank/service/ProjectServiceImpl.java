package loan.bank.service;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import loan.bank.dao.LoanProposalDAO;
import loan.bank.dao.ProjectDAO;
import loan.bank.exception.LoanProposalException;
import loan.bank.exception.ProjectException;

import loan.bank.model.LoanProposal;
import loan.bank.model.Project;
import loan.commons.dto.ProjectDTO;

@ApplicationScoped
public class ProjectServiceImpl implements ProjectService {



    @Override
    @Transactional
    public ProjectDTO analyseProject(ProjectDTO projectDTO) {
        System.out.println(projectDTO);
        return projectDTO;
    }


}
