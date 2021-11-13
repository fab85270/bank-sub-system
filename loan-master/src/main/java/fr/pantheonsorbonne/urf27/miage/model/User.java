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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = true)
    private String mail;
    private Gender gender;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idAddress", nullable = false)
    private Address address;
    private Instant birthDate; //Ici mettre des relations ?? OneToOne?

    /*Getters/Setters de la classe User */
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
