package fr.pantheonsorbonne.urf27.miage.dao;

import fr.pantheonsorbonne.urf27.miage.model.Address;
import fr.pantheonsorbonne.urf27.miage.model.RealEstate;

public interface RealEstateDAO {

    public RealEstate createRealEstate(RealEstate realEstate);

    public RealEstate createRealEstate(Address address, double surface, int constructionYear, double price, int numberOfRooms);
}
