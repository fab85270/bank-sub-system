package loan.commons.dto;


public class AddressDTO {

    private String streetName;

    private int streetNumber;

    private long postalCode;

    private String city;

    private String complementaryAddress;

    public AddressDTO() {
    }

    public AddressDTO(String streetName, int streetNumber, long postalCode, String city, String complementaryAddress) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.complementaryAddress = complementaryAddress;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(long postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getComplementaryAddress() {
        return complementaryAddress;
    }

    public void setComplementaryAddress(String complementaryAddress) {
        this.complementaryAddress = complementaryAddress;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                ", streetName='" + streetName + '\'' +
                ", streetNumber=" + streetNumber +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", complementaryAddress='" + complementaryAddress + '\'' +
                '}';
    }
}
