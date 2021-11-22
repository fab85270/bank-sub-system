package fr.pantheonsorbonne.urf27.miage.dao;


import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Broker;
import fr.pantheonsorbonne.urf27.miage.model.Gender;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@ApplicationScoped //Injection d'objets durant la durée de l'application
public class BorrowerDAOImpl implements BorrowerDAO{

    @PersistenceContext(name = "mysql") //Ajout du context de persistence connect à la base de donnée "mySql"
    EntityManager em;

    @Override
    public Borrower findMatchingBorrower(String email) throws EntityNotFoundException {
        try{
            Borrower b = (Borrower) em.createQuery("Select b from Borrower b where b.email=:email").setParameter("email",email).getSingleResult();
            return b;
        }catch(NoResultException e) {
            throw new EntityNotFoundException();
        }
    }


    @Override
    @Transactional
    public List<Borrower> listBorrower(){
        return em.createQuery("Select b from Borrower b").getResultList();
    }

    @Override
    @Transactional
    public void deleteBorrower(String email){
        em.createQuery("delete from Borrower b where b.email=:email").setParameter("email",email).executeUpdate();
    }

    @Override
    @Transactional
    public void clearBorrowers(){
        em.createQuery("delete from Borrower b").executeUpdate();
    }

    @Override
    @Transactional
    public void createNewBorrower(String name, Instant birthdate, Project project, Gender gender, String mail, Broker broker){

        int numOfBorrowers = em.createQuery("Select b from Borrower b where b.email=:email").setParameter("email",mail).getResultList().size();

        if(numOfBorrowers==0){ //Borrower doesnt exists
            Borrower borrower = new Borrower(name,birthdate,project,gender,mail,broker);
            em.persist(borrower);
        }
    }

}
