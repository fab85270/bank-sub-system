package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;

@Entity
public class Broker extends User{

    /*Attributs privés propres à la classe User*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBroker", nullable = false)
    private Long idBroker;

    private Dossier borrowerDossier; // ???

    public Broker(Long idBroker, Dossier borrowerDossier) {
        this.idBroker = idBroker;
        this.borrowerDossier = borrowerDossier;
    }


    /*@Column(name = "role", nullable = false)
    private String role; //Mettre un type énuméré pour un rôle ? Qui sera défini un peu comme une classe ?
*/

    /*Accesseurs/Getters de la classe Broker*/
    public Long getIdClient() {
        return idBroker;
    }

    public void setIdClient(Long idClient) {
        this.idBroker = idClient;
    }

}
