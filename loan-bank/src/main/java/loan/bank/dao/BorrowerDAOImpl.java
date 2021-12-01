package loan.bank.dao;

import loan.bank.exception.entityNotFound;
import loan.bank.model.Borrower;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class BorrowerDAOImpl implements BorrowerDao {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    public Borrower findMatchingBorrower(int borrowerId) throws entityNotFound.entityNotFoundException {
        try {
            return (Borrower) em.find(Borrower.class, borrowerId);
        } catch (NoResultException e) {
            throw new entityNotFound.entityNotFoundException(borrowerId);
        }
    }
}
