package fr.pantheonsorbonne.urf27.miage.dao;


import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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


}
