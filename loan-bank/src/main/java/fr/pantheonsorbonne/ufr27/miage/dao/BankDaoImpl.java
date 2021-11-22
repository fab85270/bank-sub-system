package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Address;
import fr.pantheonsorbonne.ufr27.miage.model.Bank;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class BankDaoImpl implements BankDao {

    @PersistenceContext(name = "mysql") //Ajout du context de persistence connect à la base de donnée "mySql"
    EntityManager em;

    @Override
    public Bank findMatchingBank(String bankName) throws EntityNotFound {
        try{
            Bank b = (Bank) em.createQuery("Select b from Bank b where b.bankName=:bankName").setParameter("bankName",bankName).getSingleResult();
            return b;
        }catch(NoResultException e) {
            throw new entityNotFoundException();
        }
    }

    @Override
    @Transactional
    public void createNewBank(String bankName, Address address, Broker idBroker){

        /Une banque ne pourra être ajoutée que si elle n'existe pas (selon son name)/

        int numOfBank = em.createQuery("Select b from Bank b where b.bankName=:bankName").setParameter("bankName",bankName).getResultList().size();

        if (numOfBank==0){ //Bank doesn't exist
            Bank bank = new Bank(bankName,address,idBroker);
            em.persist(bank);
        }
    }

    @Override
    @Transactional
    public void clearBanks(){ em.createQuery("delete from Bank ").executeUpdate();}

    @Override
    @Transactional
    public void clearBank(String bankName){
        em.createQuery("delete from Bank b where b.bankName=:bankName").setParameter("bankName",bankName).executeUpdate();
    }
}
