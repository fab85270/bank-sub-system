package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import javax.ws.rs.client.Client;


@Entity
public class Broker extends User{
    /*Attributs privés propres à la classe User*/

    public enum Role {
        OFFICER,
        BROKER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idClient;
    private Role role; //Ou sinon ici mettre un type énuméré en dehors de la classe ? A voir! -> Supprimer Rôle ?

    /*Constructeur de la classe Broker*/
    public Broker(){}

    public Broker(String firstName,String lastName,String mail,Gender gender, Address address, Instant birthDate, Role role){
        super(firstName,lastName,mail,gender,address,birthDate);
        this.role = role; //Ici ajouter d'autres attributs que rôle pour le broker ??
    }
}
