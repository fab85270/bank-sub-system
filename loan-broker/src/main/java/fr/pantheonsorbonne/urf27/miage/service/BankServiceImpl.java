package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.dao.BankDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.BankExceptions;
import fr.pantheonsorbonne.urf27.miage.exception.EntityNotFoundException;
import fr.pantheonsorbonne.urf27.miage.model.Bank;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@ApplicationScoped
public class BankServiceImpl implements BankService{

    @PersistenceContext
    EntityManager em;

    @Inject
    BankDAOImpl bankDAO;

    public Bank createBank(Bank bank) throws BankExceptions.BankAlreadyExists {
        return bankDAO.createNewBank(bank);
    }

    public Bank findBank(int idBank) throws EntityNotFoundException{
        return bankDAO.findBank(idBank);
    }

    public Collection<Bank> getBanks(){
        return bankDAO.getBanks();
    }

    public void createBankTest(){
        bankDAO.createBankTest();
    }
}
