package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class User {

    public enum Gender{
        FEMALE,
        MALE,
        UNIDENTIFIED
    }

    /* Variables privées propres à un utilisateur*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private Gender gender;
    private Address address;
    private Instant birthDate;


    /*Constructeurs de la classe User*/

    public User(){}

    public User(String firstName,String lastName, String mail, Gender gender, Address address,Instant birthdDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    /*Getters/Setters de la classe*/
}
