package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Officer extends User{
    /* Variables privées propres à une Officer*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String telNumber; //Un officer possède un numéro de teléphone sur lequel on peut le contacter.
    private String role;

    /*Constructeurs de la classe Officer*/

    public Officer(){}

    public Officer(String firstName, String lastName, String mail, Gender gender, Address address, Instant birthDate, String telNumber){
        super(firstName,lastName,mail,gender,address,birthDate);
        this.role = "OFFICER"; //Mettre un type énuméré comme pour Broker ??
        this.telNumber = telNumber;
    }

    /*Getters/Accesseurs de la classe Officer*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
