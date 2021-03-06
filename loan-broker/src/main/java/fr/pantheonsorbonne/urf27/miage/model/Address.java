package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAddress")
    private Integer idAddress;

    @Column(name = "streetName", nullable = false)
    private String streetName;

    @Column(name = "streetNumber", nullable = false)
    private int streetNumber;

    @Column(name = "postalCode", nullable = false)
    private long postalCode;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "complementaryAddress")
    private String complementaryAddress;

    public Address() {
    }

    public Address(String streetName, int streetNumber, long postalCode, String city, String complementaryAddress) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.complementaryAddress = complementaryAddress;
    }

    /*Getter & Setters */
    public Integer getIdAddress() {
        return idAddress;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(long postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getComplementaryAddress() {
        return complementaryAddress;
    }

    public void setComplementaryAddress(String complementaryAddress) {
        this.complementaryAddress = complementaryAddress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "idAddress=" + idAddress +
                ", streetName='" + streetName + '\'' +
                ", streetNumber=" + streetNumber +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", complementaryAddress='" + complementaryAddress + '\'' +
                '}';
    }
}
