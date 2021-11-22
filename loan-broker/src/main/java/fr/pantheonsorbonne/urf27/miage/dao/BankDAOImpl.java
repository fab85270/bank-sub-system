package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Address;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Broker;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class BankDAOImpl implements BankDAO{

    @PersistenceContext(name = "mysql") //Ajout du context de persistence connect à la base de donnée "mySql"
    EntityManager em;

    @Override
    public Bank findMatchingBank(String name) throws EntityNotFoundException {
        try{
            Bank b = (Bank) em.createQuery("Select b from Bank b where b.name=:name").setParameter("name",name).getSingleResult();
            return b;
        }catch(NoResultException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    @Transactional
    public void createBaseBanks(){
        int numOfBanks = em.createQuery("Select b from Bank b").getResultList().size();
        if(numOfBanks==0) { //Cas table Bank vide
            /*Ici faire l'insertion?*/
        }
    }

    @Override
    @Transactional
    public Bank createNewBank(String name, Address address, Broker idBroker){
        /*Une banque ne pourra être ajoutée que si elle n'existe pas*/

        int numOfBank = em.createQuery("Select b from Bank b where b.name=:name").setParameter("name",name).getResultList().size();

        if (numOfBank==0){ //Cas ou la banque existe pas déja
            Bank bank = new Bank(name,address,idBroker);
            em.persist(bank);
            return bank;
        }
    }

    @Override
    @Transactional
    public void clearBanks(){ em.createQuery("delete from Bank ").executeUpdate();}

    @Override
    @Transactional
    public void clearBank(String name){
        em.createQuery("delete from Bank b where b.name=:name").setParameter("name",name).executeUpdate();
    }

    @Override
    @Transactional
    public void addBrokerBank(String nameBank,Broker broker)  throws EntityNotFoundException{
        /*Récupération de la Bank concerné selon son nom indiqué en paramètre*/

        //Bank b = this.findMatchingBank(nameBank).getIdBroker();


    }


}
