package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;

@Entity
public class Borrower extends User{

    /*Attributs privés propres à la classe User*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCustomer", nullable = false)
    private Long idCustomer;
/*
    @Column(name = "role", nullable = false)
    private String role; //Mettre un type énuméré pour un rôle ? Qui sera défini un peu comme une classe ?
*/
    @ManyToOne(optional = false)
    @JoinColumn(name = "idDossier", nullable = false)
    private Dossier dossier; //Dossier contenant tous les fichiers clients et informations personnelles pour constituer le dossier

    /*Constructeur de la classe Borrower*/

    public Borrower(Dossier dossier) {
        this.dossier = dossier;
    }

    /* Setters/Getters de la classe Customer */
    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

}
