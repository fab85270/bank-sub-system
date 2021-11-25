package loan.bank.model;

import javax.persistence.*;

@Entity
public class RealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "realEstateId", nullable = false)
    private Integer realEstateId;

    @OneToOne(optional = true)
    @JoinColumn(name="addressId",nullable = false)
    private Address addressId;

    @Column(name = "surface", nullable = false)
    private double surface;

    @Column(name = "constructionYear", nullable = false, length = 4)
    private int constructionYear;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "numberOfRooms", nullable = false)
    private int numberOfRooms;

    /*Constructeur*/

    public RealEstate(){}

    public RealEstate(Address idAddress, double surface, int constructionYear, double price, int numberOfRooms) {
        this.addressId = idAddress;
        this.surface = surface;
        this.constructionYear = constructionYear;
        this.price = price;
        this.numberOfRooms = numberOfRooms;
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

    public int getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfParts() {
        return numberOfRooms;
    }

    public void setNumberOfParts(int numberOfParts) {
        this.numberOfRooms = numberOfParts;
    }
}
