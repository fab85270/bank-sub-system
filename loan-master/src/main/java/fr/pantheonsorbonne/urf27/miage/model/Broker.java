package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;

@Entity
public class Broker extends User{

    /*Attributs privés propres à la classe User*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBroker", nullable = false)
    private Long idBroker;

    @Column(name = "role", nullable = false)
    private String role; //Mettre un type énuméré pour un rôle ? Qui sera défini un peu comme une classe ?


    /*Accesseurs/Getters de la classe Broker*/
    public Long getIdClient() {
        return idBroker;
    }

    public void setIdClient(Long idClient) {
        this.idBroker = idClient;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
