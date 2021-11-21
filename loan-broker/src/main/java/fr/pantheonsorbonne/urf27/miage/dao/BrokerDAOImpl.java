package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.BorrowerNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Broker;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

public class BrokerDAOImpl {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    public Broker createNewBroker(String name, String email, Collection<Bank> banks, Collection<Borrower> borrowers){
        Broker b = new Broker(name,email,banks,borrowers);
        em.persist(b);
        return b;
    }

    @Override
    public Broker findMatchingBroker(String email) throws BorrowerNotFoundException{
        try{
            Broker b = (Broker) em.createQuery("Select b from Broker b where b.email=:email").setParameter("email",email).getSingleResult();
            return b;
        } catch(NoResultException e){
            throw new BorrowerNotFoundException();
        }
    }



}
