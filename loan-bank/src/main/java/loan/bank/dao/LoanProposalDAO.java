package loan.bank.dao;

import loan.bank.exception.LoanProposalException;
import loan.bank.model.LoanProposal;

import javax.transaction.Transactional;
import java.util.Collection;

public interface LoanProposalDAO {


    //Get
    //Permet de récupérer les loanproposal validé avec une bank en particulier
    Collection<LoanProposal> findMatchingPastLoanProposalWithBank(String idBank) throws LoanProposalException.LoanProposalBankNotFoundException;

    //Post
    LoanProposal post(LoanProposal proposal);

    //Post
    LoanProposal put(LoanProposal proposal);
}
