package loan.bank.model;

import org.javamoney.moneta.Money;

import javax.persistence.*;


@Entity
public class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "realEstateId", nullable = false)
    private Integer realEstateId;

    @OneToOne
    @JoinColumn(name = "addressId", nullable = false)
    private Address addressId;

    @Column(name = "surface", nullable = false)
    private double surface;

    @Column(name = "constructionYear", nullable = false)
    private int constructionYear;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "numberOfParts", nullable = false)
    private int numberOfParts;

    public RealEstate(){};

        public RealEstate(Address idAddress, double surface, Integer constructionYear, double price, Integer numberOfParts) {
        this.addressId = idAddress;
        this.surface = surface;
        this.constructionYear = constructionYear;
        this.price = price;
        this.numberOfParts = numberOfParts;
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
        return numberOfParts;
    }

    public void setNumberOfParts(int numberOfParts) {
        this.numberOfParts = numberOfParts;
    }
}
