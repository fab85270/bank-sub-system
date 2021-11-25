package loan.bank.dao;

import loan.bank.exception.LoanProposalException;
import loan.bank.model.LoanProposal;

import javax.transaction.Transactional;

public interface LoanProposalDAO {


    //Get
    LoanProposal findMatchingLoanProposal(int id) throws LoanProposalException.LoanProposalNotFoundException;

    //Post
    LoanProposal post(LoanProposal proposal);

    //Post
    LoanProposal put(LoanProposal proposal);
}
