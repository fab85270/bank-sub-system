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

    @Column(name = "name", nullable = false)
    private String name;

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

    public Borrower(long idBorrower, String name, Instant birthdate, Project idProject, Gender gender, String email) {
        this.idBorrower = idBorrower;
        this.name = name;
        this.birthdate = birthdate;
        this.idProject = idProject;
        this.gender = gender;
        this.email = email;
    }

    public long getIdBorrower() {
        return idBorrower;
    }

    public void setIdBorrower(long idBorrower) {
        this.idBorrower = idBorrower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
