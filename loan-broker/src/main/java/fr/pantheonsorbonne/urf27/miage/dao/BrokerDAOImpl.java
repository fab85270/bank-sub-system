package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Broker;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.lang.Override;

@ApplicationScoped
public class BrokerDAOImpl implements BrokerDAO {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Inject
    BankDAOImpl bankDAO;

    @Override
    @Transactional
    public Broker createNewBroker(String firstName, String lastName, String email, Collection<Bank> banks, Collection<Borrower> borrowers) {

        /*Un Broker ne pourra être ajouté si il existe en bdd*/
        int numOfBroker = em.createQuery("Select b from Broker b where b.email=:email")
                .setParameter("email", email)
                .getResultList()
                .size();

        Broker broker = null;
        if (numOfBroker == 0) {
            broker = new Broker(firstName, lastName, email, banks, borrowers);
            em.persist(broker);
        }
        return broker;
    }

    @Override
    @Transactional
    public Broker createNewBroker(String firstName, String lastName, String email) {
        Broker broker = new Broker(firstName, lastName, email);
        em.persist(broker);
        return broker;
    }

    @Override
    @Transactional
    public Broker createNewBroker(Broker broker) {
        em.persist(broker);
        return broker;
    }

    @Override
    @Transactional
    public Broker getBrokerByEmail(String email) throws EntityNotFoundException {
        try {
            return (Broker) em.createQuery("Select b from Broker b where b.email=:email").setParameter("email", email).getSingleResult();

        } catch (NoResultException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    @Transactional
    public Broker getBrokerById(int id) throws EntityNotFoundException {
        try {
            return em.find(Broker.class, id);
        } catch (NoResultException e) {
            throw new EntityNotFoundException();
        }
    }


//    @Override
//    @Transactional
//    public void addBankBroker(String mail, Bank bank) throws EntityNotFoundException {
//        /*Récupération du broker concerné selon le mail indiqué en paramètre*/
//        bankDAO.createNewBank(bank);
//        findMatchingBroker(mail).getBanks().add(bank);
//
//    }

    @Override
    @Transactional
    public void addBorrowerBroker(String mail, Borrower borrower) throws EntityNotFoundException {
        /*Récupération du broker concerné selon le mail indiqué en paramètre*/
        Collection borrowersCollection = getBrokerByEmail(mail).getBorrowers();

        /*Ajoût de la bank dans la Collection de banks du broker */

        borrowersCollection.add(borrower);

        /*Ajoût du borrowers au sein de la base de données*/
    }

    @Override
    @Transactional
    public void clearBrokers() {
        em.createQuery("delete from Broker").executeUpdate();
    }

    @Override
    @Transactional
    public void clearBroker(String mail) {
        em.createQuery("delete from Broker b where b.email =:mail").setParameter("mail", mail).executeUpdate();
    }
}
