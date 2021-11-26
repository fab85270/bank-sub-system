package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.model.Address;
import fr.pantheonsorbonne.urf27.miage.model.RealEstate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.core.Context;

@ApplicationScoped
public class RealEstateDAOImpl implements RealEstateDAO {

    @PersistenceContext
    EntityManager em;


    @Override
    @Transactional
    public RealEstate createRealEstate(RealEstate realEstate) {
        em.persist(realEstate);
        return realEstate;
    }

    @Override
    @Transactional
    public RealEstate createRealEstate(Address address, double surface, int constructionYear, double price, int numberOfRooms) {
        RealEstate realEstate = new RealEstate(address, surface, constructionYear, price, numberOfRooms);
        em.persist(realEstate);
        return realEstate;
    }
}
