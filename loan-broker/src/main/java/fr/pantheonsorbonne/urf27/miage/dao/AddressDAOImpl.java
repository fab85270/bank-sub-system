package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.model.Address;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class AddressDAOImpl implements AddressDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public Address createAddress(Address address) {
        em.persist(address);
        return address;
    }

    @Override
    public Address createAddress(String streetName, int streetNumber, long postalCode, String city, String complementaryAddress) {
        Address address = new Address(streetName, streetNumber, postalCode, city, complementaryAddress);
        em.persist(address);
        return address;
    }
}
