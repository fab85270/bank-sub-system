package loan.bank.dao;

import loan.bank.exception.entityNotFound;
import loan.bank.model.Borrower;
import loan.commons.dto.BorrowerDTO;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class BorrowerDAOImpl implements BorrowerDAO {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    @Transactional
    public Borrower findMatchingBorrower(int borrowerId) throws entityNotFound.entityNotFoundException {
        try {
            return (Borrower) em.find(Borrower.class, borrowerId);
        } catch (NoResultException e) {
            throw new entityNotFound.entityNotFoundException(borrowerId);
        }
    }

    @Override
    @Transactional
    public Borrower createBorrower(BorrowerDTO borrowerDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Borrower borrower = modelMapper.map(borrowerDTO, Borrower.class);
        em.persist(borrower);
        return borrower;
    }
}
