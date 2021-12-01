package loan.commons.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class BorrowerDTO {

    private AddressDTO addressId;

    private String email;

    private String firstName;

    private String lastName;

    private String gender;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthdate;

    private String employmentContract;

    private double annualSalary;

    private double firstDeposit;

    private String phoneNumber;

    private double requiredInterest;

    private double monthlyRefund;

    private double debtRatio;

    public BorrowerDTO() {
    }

    public BorrowerDTO(AddressDTO addressId, String email, String firstName, String lastName, String gender,
                       LocalDate birthdate, String employmentContract, double annualSalary, double firstDeposit,
                       String phoneNumber, double requiredInterest, double monthlyRefund, double debtRatio) {
        this.addressId = addressId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.employmentContract = employmentContract;
        this.annualSalary = annualSalary;
        this.firstDeposit = firstDeposit;
        this.phoneNumber = phoneNumber;
        this.requiredInterest = requiredInterest;
        this.monthlyRefund = monthlyRefund;
        this.debtRatio = debtRatio;
    }

    public AddressDTO getAddressId() {
        return addressId;
    }

    public void setAddressId(AddressDTO addressId) {
        this.addressId = addressId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmploymentContract() {
        return employmentContract;
    }

    public void setEmploymentContract(String employmentContract) {
        this.employmentContract = employmentContract;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public double getFirstDeposit() {
        return firstDeposit;
    }

    public void setFirstDeposit(double firstDeposit) {
        this.firstDeposit = firstDeposit;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getRequiredInterest() {
        return requiredInterest;
    }

    public void setRequiredInterest(double requiredInterest) {
        this.requiredInterest = requiredInterest;
    }

    public double getMonthlyRefund() {
        return monthlyRefund;
    }

    public void setMonthlyRefund(double monthlyRefund) {
        this.monthlyRefund = monthlyRefund;
    }

    public double getDebtRatio() {
        return debtRatio;
    }

    public void setDebtRatio(double debtRatio) {
        this.debtRatio = debtRatio;
    }

    @Override
    public String toString() {
        return "BorrowerDTO{" +
                "addressId=" + addressId +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate=" + birthdate +
                ", employmentContract='" + employmentContract + '\'' +
                ", annualSalary=" + annualSalary +
                ", firstDeposit=" + firstDeposit +
                ", phoneNumber=" + phoneNumber +
                ", requiredInterest=" + requiredInterest +
                ", monthlyRefund=" + monthlyRefund +
                ", debtRatio=" + debtRatio +
                '}';
    }
}
