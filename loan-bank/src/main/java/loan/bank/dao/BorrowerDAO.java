package loan.bank.dao;

import loan.bank.exception.entityNotFound;
import loan.bank.model.Borrower;

public interface BorrowerDAO {
    Borrower findMatchingBorrower(int borrowerId) throws entityNotFound.entityNotFoundException;
}
