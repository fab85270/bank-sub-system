package fr.pantheonsorbonne.urf27.miage.service;

//import fr.pantheonsorbonne.ufr27.miage.dto.*;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@ApplicationScoped
public class BrokerServiceImpl implements BrokerService {

    @PersistenceContext
    EntityManager em;

    @Inject
    BrokerDAOImpl brokerDAO;

//    @Override
//    public Broker createBroker(Broker broker) {
//        return brokerDAO.createNewBroker(brokerDto.getFirstName(), brokerDto.getLastName(), brokerDto.getEmail());
//        return null;
//    }

    @Override
    public Collection<Bank> getBrokersBanks(int brokerId) throws EntityNotFoundException {
        System.out.println(brokerDAO.getBrokerById(brokerId).getBanks());
        return brokerDAO.getBrokerById(brokerId).getBanks();
    }
}
