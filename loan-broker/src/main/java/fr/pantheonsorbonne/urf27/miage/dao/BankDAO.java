package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.exception.BankExceptions;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Address;
import fr.pantheonsorbonne.urf27.miage.model.Bank;
import java.util.Collection;

import java.util.List;

public interface BankDAO {

    Bank findMatchingBank(String name) throws BankExceptions.BankAlreadyExists;

    Bank findBank(int idBank) throws EntityNotFoundException, BankExceptions.BankNotFound;

    Bank createNewBank(String name, Address address) throws BankExceptions.BankAlreadyExists;

    Bank createNewBank(Bank bank) throws BankExceptions.BankAlreadyExists;

    void clearBanks();

    void clearBank(String name);

    Collection<Bank> getBanks();

    void createBankTest();

}