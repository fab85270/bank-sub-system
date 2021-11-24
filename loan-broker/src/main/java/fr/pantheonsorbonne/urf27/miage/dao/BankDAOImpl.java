package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Address;
import fr.pantheonsorbonne.urf27.miage.model.Bank;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BankDAOImpl implements BankDAO {

    @PersistenceContext(name = "mysql") //Ajout du context de persistence connect à la base de donnée "mySql"
    EntityManager em;

    @Override
    public Bank findMatchingBank(String name) throws EntityNotFoundException {
        try {
            Bank b = (Bank) em.createQuery("Select b from Bank b where b.bankName=:name").setParameter("name", name).getSingleResult();
            return b;
        } catch (NoResultException e) {
            throw new EntityNotFoundException();
        }
    }


    @Override
    @Transactional
    public void createNewBank(String name, Address address) {
        /*Une banque ne pourra être ajoutée que si elle n'existe pas (selon son name)*/
        int numOfBank = em.createQuery("Select b from Bank b where b.bankName=:name").setParameter("name", name).getResultList().size();

        if (numOfBank == 0) { //Bank doesn't exist
            //Bank bank = new Bank(name, address, broker);
            //em.persist(bank);
        }
    }

    @Override
    @Transactional
    public void createNewBank(Bank bank) {
        em.persist(bank);
    }

    @Override
    @Transactional
    public void clearBanks() {
        em.createQuery("delete from Bank ").executeUpdate();
    }

    @Override
    @Transactional
    public void clearBank(String name) {
        em.createQuery("delete from Bank b where b.bankName=:name").setParameter("name", name).executeUpdate();
    }

    @Override
    @Transactional
    public void addBrokerBank(String nameBank) throws EntityNotFoundException {
        /*Récupération de la Bank concerné selon son nom indiqué en paramètre*/

        //Bank b = this.findMatchingBank(nameBank).getIdBroker();

    }

    @Override
    @Transactional
    public List<Bank> listBanks() {
        return em.createQuery("Select b from Bank b").getResultList();
    }


}
