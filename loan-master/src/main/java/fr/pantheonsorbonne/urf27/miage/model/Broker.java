package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import javax.ws.rs.client.Client;


@Entity
public class Broker extends User{

    /*Attributs privés propres à la classe User*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String role; //Mettre un type énuméré pour un rôle ? Qui sera défini un peu comme une classe ?

    /*Constructeur de la classe Broker*/
    public Broker(){}

    public Broker(String firstName,String lastName,String mail,Gender gender, Address address, Instant birthDate, String role){
        super(firstName,lastName,mail,gender,address,birthDate);
        this.role = "BROKER"; //Ici ajouter d'autres attributs que rôle pour le broker ??
    }
}
