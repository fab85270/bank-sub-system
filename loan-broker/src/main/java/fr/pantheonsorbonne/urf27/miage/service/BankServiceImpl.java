package fr.pantheonsorbonne.urf27.miage.service;

import fr.pantheonsorbonne.urf27.miage.dao.BankDAOImpl;
import fr.pantheonsorbonne.urf27.miage.exception.BankExceptions;
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

    /*
    *Cree une bank
    */
    public Bank createBank(Bank bank) throws BankExceptions.BankAlreadyExists {
        return bankDAO.createNewBank(bank);
    }

    /*
    * Permet de rechercher une banque a partir de son ID
    */
    public Bank findBank(int idBank) throws BankExceptions.BanksNotFoundId{
        return bankDAO.findBank(idBank);
    }

    /*
    * Renvoie toutes les banques presentes dans la BDD
    */
    public Collection<Bank> getBanks() throws BankExceptions.BanksNotFound{
        return bankDAO.getBanks();
    }
}
