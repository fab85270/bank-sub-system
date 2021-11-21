package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.BorrowerNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Broker;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;


public interface BrokerDAO {

    Broker findMatchingBroker(String mail) throws BorrowerNotFoundException;

    @Transactional
    Broker createNewBroker(String name, String email, Collection<Bank> banks, Collection<Borrower> borrowers);

    @Transactional
    List<Broker> listBroker();

}
