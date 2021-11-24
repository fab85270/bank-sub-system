package loan.bank.dao;

import loan.bank.exception.ProjectException;
import loan.bank.model.LoanProposal;
import loan.bank.model.Project;

import javax.transaction.Transactional;

public interface ProjectDAO {


    //Get
    Project findById(int id) throws  ProjectException.ProjectNotFoundException;

    //Post
    @Transactional
    Project post(Project project);

    //Post
    @Transactional
    Project put(Project project);
}
