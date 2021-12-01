package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;

@Entity
public class RealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "realEstateId")
    private Integer realEstateId;

    @OneToOne(optional = true)
    @JoinColumn(name="addressId")
    private Address addressId;

    @Column(name = "surface", nullable = false)
    private double surface;

    @Column(name = "constructionYear", nullable = false)
    private Integer constructionYear;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "numberOfRooms", nullable = false)
    private Integer numberOfRooms;

    /*Constructeur*/

    public RealEstate(){}

    public RealEstate(Address idAddress, double surface, Integer constructionYear, double price, Integer numberOfRooms) {
        this.addressId = idAddress;
        this.surface = surface;
        this.constructionYear = constructionYear;
        this.price = price;
        this.numberOfRooms = numberOfRooms;
    }

    public void setRealEstateId(Integer realEstateId) {
        this.realEstateId = realEstateId;
    }

    public Integer getRealEstateId() {
        return realEstateId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public Integer getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Integer constructionYear) {
        this.constructionYear = constructionYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getnumberOfRooms() {
        return numberOfRooms;
    }

    public void setnumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "realEstateId=" + realEstateId +
                ", addressId=" + addressId +
                ", surface=" + surface +
                ", constructionYear=" + constructionYear +
                ", price=" + price +
                ", numberOfRooms=" + numberOfRooms +
                '}';
    }
}
