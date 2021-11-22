package fr.pantheonsorbonne.ufr27.miage.dto;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.Instant;

public class Borrower {

    private Integer idBorrower;

    private String firstName;

    private String lastName;

    private Instant birthdate;

    private int idProject;

    private Gender gender;

    private String email;

    private int idBroker;

    public Borrower() {
    }

    public Borrower(Integer idBorrower, String firstName, String lastName, Instant birthdate, int idProject, Gender gender, String email, int idBroker) {
        this.idBorrower = idBorrower;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.idProject = idProject;
        this.gender = gender;
        this.email = email;
        this.idBroker = idBroker;
    }

    public int getIdBroker() {
        return idBroker;
    }

    public void setIdBroker(int idBroker) {
        this.idBroker = idBroker;
    }

    public Integer getIdBorrower() {
        return idBorrower;
    }

    public void setIdBorrower(Integer idBorrower) {
        this.idBorrower = idBorrower;
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

    public Instant getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Instant birthdate) {
        this.birthdate = birthdate;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
