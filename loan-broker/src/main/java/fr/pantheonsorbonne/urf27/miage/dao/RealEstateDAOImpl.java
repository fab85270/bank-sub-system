package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.model.Address;
import fr.pantheonsorbonne.urf27.miage.model.RealEstate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Context;

@ApplicationScoped
public class RealEstateDAOImpl implements RealEstateDAO {

    @PersistenceContext
    EntityManager em;


    @Override
    public RealEstate createRealEstate(RealEstate realEstate) {
        em.persist(realEstate);
        return realEstate;
    }

    @Override
    public RealEstate createRealEstate(Address address, double surface, int constructionYear, double price, int numberOfParts) {
        RealEstate realEstate = new RealEstate(address, surface, constructionYear, price, numberOfParts);
        em.persist(realEstate);
        return realEstate;
    }
}
