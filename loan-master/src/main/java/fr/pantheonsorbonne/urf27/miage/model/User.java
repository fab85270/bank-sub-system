package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;

@Entity
public class User {
    /* Variables privées propres à une Bank*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private
}
