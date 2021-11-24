package loan.bank.dao;

import loan.bank.model.Address;
import loan.bank.model.Bank;

public interface BankDao {
    Bank findMatchingBank(String bankName);

    void createNewBank(String bankName, Address address, Broker idBroker);

    void clearBanks();

    void clearBank(String bankName);
}