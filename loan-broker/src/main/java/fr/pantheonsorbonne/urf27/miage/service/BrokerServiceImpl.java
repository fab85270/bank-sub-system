package fr.pantheonsorbonne.urf27.miage.service;

//import fr.pantheonsorbonne.ufr27.miage.dto.*;

import fr.pantheonsorbonne.urf27.miage.dao.AddressDAOImpl;
import fr.pantheonsorbonne.urf27.miage.dao.RealEstateDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Project;
import fr.pantheonsorbonne.urf27.miage.model.RealEstate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class BrokerServiceImpl implements BrokerService {

    @PersistenceContext
    EntityManager em;

    @Inject
    RealEstateDAOImpl realEstateDAO;

    @Inject
    AddressDAOImpl addressDAO;

    //A SUPPRIMER ???
    @Override
    @Transactional
    public Collection<Bank> getBrokersBanks(int brokerId) throws EntityNotFoundException {
//        System.out.println(brokerDAO.getBrokerById(brokerId).getBanks());
//        return brokerDAO.getBrokerById(brokerId).getBanks();

        return null;
    }

    /*
    *Cree un projet
    */
    @Override
    @Transactional
    public Project createProject(RealEstate realEstate, String projectDescription, double requiredValue, int durationMax) {
        addressDAO.createAddress(realEstate.getAddressId());
        realEstate.setAddressId(realEstate.getAddressId());

//        realEstateDAO.createRealEstate()

        return null;
    }
}
