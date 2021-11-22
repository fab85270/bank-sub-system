package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Borrower;
import fr.pantheonsorbonne.urf27.miage.model.Broker;

import java.util.Collection;
import java.util.List;


public interface BrokerDAO {

    Broker findMatchingBroker(String mail) throws EntityNotFoundException;

    void createNewBroker(String name, String email, Collection<Bank> banks, Collection<Borrower> borrowers);

    List<Broker> listBroker();

    void addBankBroker(String mail,Bank bank) throws EntityNotFoundException;

    void addBorrowerBroker(String mail,Borrower borrower) throws EntityNotFoundException;

    void clearBrokers();

    void clearBroker(String mail);







}
