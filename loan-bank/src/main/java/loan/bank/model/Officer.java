package loan.bank.model;

import javax.persistence.*;

@Entity
public class Officer {
    /* Variables privées propres à une Officer*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOfficer", nullable = false)
    private Integer idOfficer;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique=true)
    private String email;

    @Column(name = "telNumber", nullable = false)
    private long telNumber; //Un officer possède un numéro de teléphone sur lequel on peut le contacter.

    /*Constructeur*/
    public Officer(){}

    public Officer(String firstName, String lastName, String email, long telNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telNumber = telNumber;
    }

    /*Getter & Setter*/

    public Integer getId() {
        return idOfficer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(long telNumber) {
        this.telNumber = telNumber;
    }
}
