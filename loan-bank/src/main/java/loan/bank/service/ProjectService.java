package loan.bank.service;

import loan.bank.exception.ProjectException;

import javax.transaction.Transactional;

public interface ProjectService {

    void emitProposal(int projectId) throws  ProjectException.ExpiredProjectException;


    @Transactional
    void addInterestRateProposal(int proposalId, double rate);

    @Transactional
    void addLoanDurationProposal(int proposalId, int duration);

    @Transactional
    void validProposal(int proposalId, int duration);
}
