package fr.pantheonsorbonne.urf27.miage.dao;


import fr.pantheonsorbonne.urf27.miage.exception.BorrowerNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Broker;
import fr.pantheonsorbonne.urf27.miage.model.Gender;
import fr.pantheonsorbonne.urf27.miage.model.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
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
    public Borrower findMatchingBorrower(String email) throws BorrowerNotFoundException {
        try{
            Borrower b = (Borrower) em.createQuery("Select b from Borrower b where b.email=:email").setParameter("email",email).getSingleResult();
            return b;
        }catch(NoResultException e) {
            throw new BorrowerNotFoundException();
        }
    }


    @Override
    @Transactional
    public void createBaseBorrower(){
        int numOfBorrowers = em.createQuery("Select b from Borrower b").getResultList().size();
        if(numOfBorrowers==0) { //Cas table Borrowers vide
           // Borrower bob = new Borrower("Bob","26/06/1985",1,Gender.MALE,"bob@gmail.com",new Broker());
        }
        }


    @Override
    @Transactional
    public List<Borrower> listBorrower(){
        return em.createQuery("Select b from Borrower b").getResultList();
    }


}
