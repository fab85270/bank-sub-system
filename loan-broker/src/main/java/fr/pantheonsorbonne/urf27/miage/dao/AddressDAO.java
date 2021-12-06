package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.model.Address;

public interface AddressDAO {

    public Address createAddress(Address address);

    public Address createAddress(String streetName, int streetNumber, long postalCode, String city, String complementaryAddress);
}

