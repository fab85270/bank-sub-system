package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Broker extends User{

    /*Attributs privés propres à la classe User*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBroker", nullable = false)
    private Long idBroker;

    private Dossier borrowerDossier; // ???


    private List<Bank> listBank;

    /*Constructeur de la classe Broker */

    public Broker(Dossier borrowerDossier, List<Bank> listBank) {
        this.borrowerDossier = borrowerDossier;
        this.listBank = listBank;
    }

    public Broker(List<Bank> listBank){
        this.listBank = listBank;
    }

    public Broker(){
        listBank = new ArrayList<>();
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
