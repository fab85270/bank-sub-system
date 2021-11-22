package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.Instant;

@Entity
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBorrower", nullable = false)
    private Integer idBorrower;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "birthdate", nullable = false)
    private Instant birthdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProject", nullable = false)
    private Project idProject;

    @Column(name="gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "idBroker")
    private Broker idBroker;

    public Borrower() {
    }

    public Broker getIdBroker() {
        return idBroker;
    }

    public void setIdBroker(Broker idBroker) {
        this.idBroker = idBroker;
    }

    public Borrower(Integer idBorrower, String firstName, String lastName, Instant birthdate, Project idProject, Gender gender, String email, Broker idBroker) {
        this.idBorrower = idBorrower;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.idProject = idProject;
        this.gender = gender;
        this.email = email;
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

    public Project getIdProject() {
        return idProject;
    }

    public void setIdProject(Project idProject) {
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
