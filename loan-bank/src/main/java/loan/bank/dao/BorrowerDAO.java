package loan.bank.dao;

import loan.bank.exception.entityNotFound;
import loan.bank.model.Borrower;
import loan.commons.dto.BorrowerDTO;

public interface BorrowerDAO {

    Borrower findMatchingBorrower(int borrowerId) throws entityNotFound.entityNotFoundException;

    Borrower createBorrower(BorrowerDTO borrowerDTO);
}
