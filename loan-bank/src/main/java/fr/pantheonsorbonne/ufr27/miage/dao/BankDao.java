package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Address;
import fr.pantheonsorbonne.ufr27.miage.model.Bank;

public interface BankDao {
    Bank findBank(long idBank);

    Bank addBank(long idBank, int bankName, int addressID, Address idAddress);
}
