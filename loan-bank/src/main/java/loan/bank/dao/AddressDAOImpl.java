package loan.bank.dao;

import loan.bank.model.Address;
import loan.bank.exception.entityNotFound;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AddressDAOImpl implements AddressDAO {
    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    public Address findAddress(long idAddress) throws entityNotFound {
        try {
            Address a = (Address) em.createQuery("Select a from Address a where a.idAddress=:idAddress").setParameter("idAddress", idAddress).getSingleResult();
            return a;
        } catch (NoResultException e) {
            throw new entityNotFound(); //Déclaration d'une exception métier
        }
    }

    @Override
    @Transactional
    public Address createNewAddress(int idAddress, String streetName, int streetNumber, long postalCode, String city, String complementaryAddress) {
        Address a = new Address(idAddress, streetName, streetNumber, postalCode, city, complementaryAddress);
        em.persist(a);
        return a;
    }

}
