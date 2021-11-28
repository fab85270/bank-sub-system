package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.BankExceptions;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Address;
import fr.pantheonsorbonne.urf27.miage.model.Bank;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Collection;

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
    public Bank createNewBank(String name, Address address) throws BankExceptions.BankAlreadyExists {


        /*Une banque ne pourra être ajoutée que si elle n'existe pas (selon son name)*/
        int numOfBank = em.createQuery("Select b from Bank b where b.bankName=:name")
                .setParameter("name", name)
                .getResultList()
                .size();

        if (numOfBank == 0) {
            Bank bank = new Bank(name, address);
            em.persist(bank);
            return bank;
        }

        throw new BankExceptions.BankAlreadyExists(name);
    }

    @Override
    @Transactional
    public Bank createNewBank(Bank bank) throws BankExceptions.BankAlreadyExists {
        if (em.find(Bank.class, bank.getBankId()) == null) {
            em.persist(bank);
            return bank;
        }

        throw new BankExceptions.BankAlreadyExists(bank.getBankName());
    }

    @Override
    @Transactional
    public void createBankTest() {

        Address a = new Address("ueeeez",7,23,"e","e");
        em.persist(a);
        Bank b = new Bank("Credit Mutueleeee",a);
        em.persist(b);

        Address a1 = new Address("ueeeeee",7,23,"e","e");
        em.persist(a1);
        Bank b1 = new Bank("Credit agricoleeeee",a);
        em.persist(b1);

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
    public Collection<Bank> getBanks() {
        return (Collection<Bank>) em.createQuery("Select b from Bank b").getResultList();
    }


}
