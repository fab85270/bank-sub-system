package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Address;
import fr.pantheonsorbonne.ufr27.miage.model.Bank;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class BankDaoImpl implements BankDao{
    @PersistenceContext(name = "mysqk")
    EntityManager em;

    @Override
    public Bank findBank(long idBank){
        Bank b = (Bank) em.createQuery("Select b from Bank b where b.idBank=:idBank").setParameter("idBank",idBank).getSingleResult();
        return b;
    }

    @Override
    @Transactional
    public Bank addBank(long idBank, int bankName, int addressID, Address idAddress){
       Bank b = new Bank(idBank,bankName,addressID,idAddress);
       em.persist(b);
       return b;
    }

}
