package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.exception.entityNotFound;
import fr.pantheonsorbonne.ufr27.miage.model.Address;

public interface AddressDAO {
    Address findAddress(long idAddress) throws entityNotFound;

    Address createNewAddress(int idAddress, String streetName, int streetNumber, long postalCode, String city, String complementaryAddress);
}
