package loan.bank.service;

import loan.bank.exception.LoanProposalException;
import loan.bank.exception.ProjectException;
import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectDTO;

import javax.transaction.Transactional;

public interface LoanProposalService {

    @Transactional
    LoanProposalDTO emitProposal(ProjectDTO projectDTO) throws ProjectException.ExpiredProjectException, LoanProposalException.LoanProposalRefusedException;

    @Transactional
    void saveProject(ProjectDTO projectDTO) throws ProjectException.ExpiredProjectException;

    @Transactional
    void saveProposal(LoanProposalDTO proposalDTO) throws ProjectException.ExpiredProjectException;

    @Transactional
    boolean isValidProject(ProjectDTO projectDTO);

    @Transactional
    LoanProposalDTO  validProposal(LoanProposalDTO loanProposalDTO) throws LoanProposalException.ExpiredLoanProposalException;


}
