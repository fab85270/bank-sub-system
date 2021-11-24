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

    @Column(name = "constructionYear", nullable = false)
    private Integer constructionYear;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "numberOfParts", nullable = false)
    private Integer numberOfParts;

    /*Constructeur*/

    public RealEstate(){}

    public RealEstate(Address idAddress, double surface, Integer constructionYear, double price, Integer numberOfParts) {
        this.addressId = idAddress;
        this.surface = surface;
        this.constructionYear = constructionYear;
        this.price = price;
        this.numberOfParts = numberOfParts;
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

    public Integer getNumberOfParts() {
        return numberOfParts;
    }

    public void setNumberOfParts(Integer numberOfParts) {
        this.numberOfParts = numberOfParts;
    }
}
