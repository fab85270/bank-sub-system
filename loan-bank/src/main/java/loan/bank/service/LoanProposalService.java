package loan.bank.service;

import loan.bank.exception.LoanProposalException;
import loan.bank.exception.ProjectException;
import loan.commons.dto.LoanProposalDTO;
import loan.commons.dto.ProjectDTO;

import javax.transaction.Transactional;

public interface LoanProposalService {

    LoanProposalDTO createProposal(ProjectDTO projectDTO) throws ProjectException.ExpiredProjectException, LoanProposalException.LoanProposalRefusedException, LoanProposalException.LoanProposalBankNotFoundException;

    void saveProposal(LoanProposalDTO proposalDTO) throws ProjectException.ExpiredProjectException;

}
