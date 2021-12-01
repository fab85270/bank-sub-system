package loan.bank.service;

import loan.bank.exception.ProjectException;
import loan.commons.dto.ProjectDTO;

public interface ProjectService {

    void emitProposal(int projectId) throws  ProjectException.ExpiredProjectException;

    void addInterestRateProposal(int proposalId, double rate);

    void addLoanDurationProposal(int proposalId, int duration);

    void validProposal(int proposalId, int duration);

    ProjectDTO analyseProject(ProjectDTO projectDTO);
}
