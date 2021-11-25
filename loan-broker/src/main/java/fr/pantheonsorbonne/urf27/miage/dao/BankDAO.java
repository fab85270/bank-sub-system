package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Address;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Broker;

import java.util.List;

public interface BankDAO {

    Bank findMatchingBank(String name) throws EntityNotFoundException;

    void createNewBank(String name, Address address,Broker idBroker);


    void clearBanks();

    void clearBank(String name);

    void addBrokerBank(String nameBank,Broker broker)  throws EntityNotFoundException;

    List<Bank> listBanks();
}
