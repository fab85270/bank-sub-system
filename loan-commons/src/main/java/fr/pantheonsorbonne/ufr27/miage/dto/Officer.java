package fr.pantheonsorbonne.ufr27.miage.dto;

public class Officer {
    /* Variables privées propres à une Officer*/

    private Long id;

    private String telNumber; //Un officer possède un numéro de teléphone sur lequel on peut le contacter.

    /* Constructeurs de la classe Officer */

    public Officer(String telNumber) {
        this.telNumber = telNumber;
    }
    
    public Officer(){}

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
