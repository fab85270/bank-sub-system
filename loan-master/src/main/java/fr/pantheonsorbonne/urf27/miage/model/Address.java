package fr.pantheonsorbonne.urf27.miage.model;
import javax.persistence.*;

@Entity
public class Address {

    /*Attributs privés propres à la classe User*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAddress", nullable = false)
    private Long idAddress;

    @Column(name = "streetName", nullable = false, length = 45)
    private String streetName;

    @Column(name = "streetNumber", nullable = false, length = 5)
    private int streetNumber;

    @Column(name = "postalCode", nullable = false, length = 5)
    private long postalCode;

    @Column(nullable = false)
    private String city;

    @Column(name = "complementaryAddress",length = 45)
    private String complementaryAddress;

    /*Constructeurs de la classe Address */

    public Address(){
    }

    public Address(String streetName,int streetNumber,int postalCode, String city){
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
    }



    /*Getters/Setters de la classe Address*/

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

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(long postalCode) {
        this.postalCode = postalCode;
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
}
