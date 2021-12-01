package loan.commons.dto;

public class Officer {
    /* Variables privées propres à une Officer*/

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private long telNumber; //Un officer possède un numéro de teléphone sur lequel on peut le contacter.

    /*Constructeur*/
    public Officer(){}

    public Officer(Integer id, String firstName, String lastName, String email, long telNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telNumber = telNumber;
    }

    /*Getter & Setter*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(long telNumber) {
        this.telNumber = telNumber;
    }
}
