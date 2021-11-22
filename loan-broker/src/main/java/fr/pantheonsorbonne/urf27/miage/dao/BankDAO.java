package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Address;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import fr.pantheonsorbonne.urf27.miage.model.Broker;

public interface BankDAO {

    Bank findMatchingBank(String name) throws EntityNotFoundException;

    void createBaseBanks();

    Bank createNewBank(String name, Address address,Broker idBroker);

    void clearBanks();

    void clearBank(String name);

    void addBrokerBank(String nameBank,Broker broker)  throws EntityNotFoundException;
}
