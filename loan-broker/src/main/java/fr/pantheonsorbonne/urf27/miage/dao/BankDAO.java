package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Address;
import fr.pantheonsorbonne.urf27.miage.model.Bank;

import java.util.List;

public interface BankDAO {

    Bank findMatchingBank(String name) throws EntityNotFoundException;

    void createNewBank(String name, Address address);

    void createNewBank(Bank bank);

    void clearBanks();

    void clearBank(String name);

    void addBrokerBank(String nameBank)  throws EntityNotFoundException;

    List<Bank> listBanks();
}
