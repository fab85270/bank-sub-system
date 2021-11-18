package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Officer extends User{
    /* Variables privées propres à une Officer*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOfficer", nullable = false)
    private Long id;

    @Column(name = "telNumber", nullable = false, length = 10)
    private String telNumber; //Un officer possède un numéro de teléphone sur lequel on peut le contacter.

    /*@Column(name = "roleOfficer", nullable = false)
    private String roleOfficer;
*/

    /*Getters/Accesseurs de la classe Officer*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
