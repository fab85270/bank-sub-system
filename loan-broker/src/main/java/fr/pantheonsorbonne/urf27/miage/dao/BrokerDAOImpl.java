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
import java.util.List;
import java.lang.Override;

public class BrokerDAOImpl implements BrokerDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    @Transactional
    public Broker createNewBroker(String name, String email, Collection<Bank> banks, Collection<Borrower> borrowers){
        Broker b = new Broker(name,email,banks,borrowers);
        em.persist(b);
        return b;
    }

    @Override
    public Broker findMatchingBroker(String email) throws BorrowerNotFoundException{
        System.out.println("couc");
        try{
            Broker b = (Broker) em.createQuery("Select b from Broker b where b.email=:email").setParameter("email",email).getSingleResult();
            return b;
        } catch(NoResultException e){
            throw new BorrowerNotFoundException();
        }
    }

    @Override
    @Transactional
    public List<Broker> listBroker(){
        return em.createQuery("Select b from Broker b").getResultList();
    }

    @Override
    @Transactional
    public void createBaseBrokers(){
        int numOfBrokers = em.createQuery("Select b from Broker b").getResultList().size();
        if(numOfBrokers==0){
            em.persist(new Broker("Julien","phiphi@hotmail.fr"));
            em.persist(new Broker("Manuela","ManuPayet@yahoo.fr"));
        }
    }

    @Override
    @Transactional
    public void addBankBroker(String mail, Bank bank) throws BorrowerNotFoundException {
        /*Récupération du broker concerné selon le mail indiqué en paramètre*/
        Collection bankCollection = this.findMatchingBroker(mail).getBanks();

        /*Ajoût de la bank dans la Collection de banks du broker */

        bankCollection.add(bank);

        /*Ajout des modifications dans la base de données */

        /*Comment faire UPDATE ? */

        //em.createQuery("Update Broker SET banks =: bankCollection where email=:mail").setParameter("bankCollection",bankCollection,"email",mail).executeUpdate();




    }

    @Override
    @Transactional
    public void addBorrowerBroker(String mail, Borrower borrower) throws BorrowerNotFoundException{
        /*Récupération du broker concerné selon le mail indiqué en paramètre*/
        Collection borrowersCollection = this.findMatchingBroker(mail).getBorrowers();

        /*Ajoût de la bank dans la Collection de banks du broker */

        borrowersCollection.add(borrower);

        /*Ajoût du borrowers au sein de la base de données*/
    }

    @Override
    @Transactional
    public void clearBrokers(){
        em.createQuery("delete from Broker").executeUpdate();
    }

    @Override
    @Transactional
    public void clearBroker(String mail){
        em.createQuery("delete from Broker b where i.email =:mail").setParameter("mail",mail).executeUpdate();
    }
}
