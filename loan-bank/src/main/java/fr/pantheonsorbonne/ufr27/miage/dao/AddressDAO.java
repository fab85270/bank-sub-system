package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Address;

public interface AddressDAO {
    Address findAdress(long idAddress);

    Address createNewAdress(int idAddress, String streetName, int streetNumber, long postalCode, String city, String complementaryAddress);
}
