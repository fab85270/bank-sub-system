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
    public Borrower findMatchingBorrower(int borrowerId) throws entityNotFound.entityNotFoundException{
        try{
            Borrower b = (Borrower) em.createQuery("SELECT b FROM Borrower b where b.borrowerId=:borrowerId").setParameter("borrowerId",borrowerId).getSingleResult();
            return b;
        }catch(NoResultException e){
            throw new entityNotFound.entityNotFoundException(borrowerId);
        }
    }
}
