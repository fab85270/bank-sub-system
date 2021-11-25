package loan.bank.dao;

import loan.bank.exception.entityNotFound;
import loan.bank.model.Borrower;

public interface BorrowerDao {
    Borrower findMatchingBorrower(int borrowerId) throws entityNotFound;
}
