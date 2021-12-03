package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.exception.BankExceptions;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;

import java.util.Collection;

public interface BankService {

    Bank createBank(Bank bank) throws BankExceptions.BankAlreadyExists;

    Bank findBank(int idBank) throws BankExceptions.BanksNotFoundId;

    Collection<Bank> getBanks() throws BankExceptions.BanksNotFound;

    void createBankTest() throws BankExceptions.BankAlreadyExists;
}
