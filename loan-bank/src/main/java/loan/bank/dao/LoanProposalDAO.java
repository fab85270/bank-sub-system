package loan.bank.dao;

import loan.bank.exception.LoanProposalException;
import loan.bank.model.LoanProposal;

import javax.transaction.Transactional;

public interface LoanProposalDAO {


    //Get
    LoanProposal findbyId(int id) throws LoanProposalException.LoanProposalNotFoundException;

    //Post
    @Transactional
    LoanProposal post(LoanProposal proposal);

    //Post
    @Transactional
    LoanProposal put(LoanProposal proposal);
}
