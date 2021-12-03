package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.exception.BankExceptions;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;

import java.util.Collection;

public interface BankService {

    Bank createBank(Bank bank) throws EntityNotFoundException, BankExceptions.BankAlreadyExists;

    Bank findBank(int idBank) throws EntityNotFoundException, BankExceptions.BankNotFound;

    Collection<Bank> getBanks();

    void createBankTest();
}
