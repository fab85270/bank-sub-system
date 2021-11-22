package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBank", nullable = false)
    private long idBank;

    @OneToOne(optional = true)
    @JoinColumn(name="idAdress", nullable = true)
    private Address idAddress;
}
