package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Address;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AddressDAOImpl implements AddressDAO{
    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    public Address findAdress(long idAddress){
        Address a = (Address) em.createQuery("Select a from Address a where a.idAddress=:idAddress").setParameter("idAddress", idAddress).getSingleResult();
        return a;
    }
    @Override
    @Transactional
    public Address createNewAdress(int idAddress, String streetName, int streetNumber, long postalCode, String city, String complementaryAddress){
        Address a = new Address(idAddress, streetName, streetNumber,postalCode,city,complementaryAddress);
        em.persist(a);
        return a;
    }
}
