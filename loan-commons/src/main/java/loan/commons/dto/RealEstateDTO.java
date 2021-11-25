package loan.commons.dto;


public class RealEstateDTO {

    private int realEstateId;

    private AddressDTO addressId;

    private double surface;

    private int constructionYear;

    private double price;

    private int numberOfParts;

    /*Constructeur*/

    public RealEstateDTO(){}

    public RealEstateDTO(AddressDTO idAddress, double surface, int constructionYear, double price, int numberOfParts) {
        this.addressId = idAddress;
        this.surface = surface;
        this.constructionYear = constructionYear;
        this.price = price;
        this.numberOfParts = numberOfParts;
    }

    public void setRealEstateId(int realEstateId) {
        this.realEstateId = realEstateId;
    }

    public int getRealEstateId() {
        return realEstateId;
    }

    public AddressDTO getAddressId() {
        return addressId;
    }

    public void setAddressId(AddressDTO addressId) {
        this.addressId = addressId;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public int getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfParts() {
        return numberOfParts;
    }

    public void setNumberOfParts(int numberOfParts) {
        this.numberOfParts = numberOfParts;
    }

    @Override
    public String toString() {
        return "RealEstateDTO{" +
                "realEstateId=" + realEstateId +
                ", addressId=" + addressId +
                ", surface=" + surface +
                ", constructionYear=" + constructionYear +
                ", price=" + price +
                ", numberOfParts=" + numberOfParts +
                '}';
    }
}