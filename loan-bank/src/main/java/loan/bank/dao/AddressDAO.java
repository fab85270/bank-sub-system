package loan.bank.dao;

import loan.bank.exception.entityNotFound;
import loan.bank.model.Address;

public interface AddressDAO {
    Address findAddress(long idAddress) throws entityNotFound;

    Address createNewAddress(int idAddress, String streetName, int streetNumber, long postalCode, String city, String complementaryAddress);
}
