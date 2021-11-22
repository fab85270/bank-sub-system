package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Address;
import fr.pantheonsorbonne.ufr27.miage.model.Bank;

public interface BankDao {
    Bank findMatchingBank(String bankName);

    void createNewBank(String bankName, Address address, Broker idBroker);

    void clearBanks();

    void clearBank(String bankName);
}
