package fr.pantheonsorbonne.urf27.miage.dao;


import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped //Injection d'objets durant la durée de l'application
public class BorrowerDAOImpl implements BorrowerDAO {

    @PersistenceContext(name = "mysql") //Ajout du context de persistence connect à la base de donnée "mySql"
    EntityManager em;

    @Override
    public Borrower findMatchingBorrower(String email) throws EntityNotFoundException {
        try {
            Borrower b = (Borrower) em.createQuery("Select b from Borrower b where b.email=:email").setParameter("email", email).getSingleResult();
            return b;
        } catch (NoResultException e) {
            throw new EntityNotFoundException();
        }
    }


    @Override
    @Transactional
    public List<Borrower> listBorrower() {
        return em.createQuery("Select b from Borrower b").getResultList();
    }

    @Override
    @Transactional
    public void deleteBorrower(String email) {
        em.createQuery("delete from Borrower b where b.email=:email").setParameter("email", email).executeUpdate();
    }

    @Override
    @Transactional
    public void clearBorrowers() {
        em.createQuery("delete from Borrower b").executeUpdate();
    }

    @Override
    @Transactional
    public Borrower createNewBorrower(Address addressId, String email, String firstName, String lastName, Gender gender, LocalDate birthdate,
                                      EmploymentContract employmentContract, double annualSalary, double firstDeposit, String phoneNumber,
                                      double requiredInterest, int requiredDuration, double monthlyRefund, double debtRatio) {

        int numOfBorrowers = em.createQuery("Select b from Borrower b where b.email=:email").setParameter("email", email).getResultList().size();

        Borrower borrower = null;
        if (numOfBorrowers == 0) { //Borrower doesnt exists
            borrower = new Borrower(addressId, email, firstName, lastName, gender, birthdate,
                    employmentContract, annualSalary, firstDeposit, phoneNumber, requiredInterest, monthlyRefund, debtRatio);
            em.persist(borrower);
        }
        return borrower;
    }

    @Override
    @Transactional
    public Borrower createNewBorrower(Borrower borrower) {

        int numOfBorrowers = em.createQuery("Select b from Borrower b where b.email=:email").setParameter("email", borrower.getEmail()).getResultList().size();

        if (numOfBorrowers == 0) { //Borrower doesnt exists
            em.persist(borrower);
        }
        return borrower;
    }

    @Override
    public Boolean mailUsed(String mail){

        /* On cherche si un borrowers est déja crée à cette email renseigné */
        int numOfBorrowers = em.createQuery("Select b from Borrower b where b.email=:email").setParameter("email", mail).getResultList().size();

        /* Si aucun borrower ne possède cet mail, il pourra ainsi être utilisé */
        if (numOfBorrowers == 0) { //Borrower doesnt exists
            return false;
        }
            return true;
    }


}
