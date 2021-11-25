package loan.commons.dto;

import java.time.Instant;

public class BorrowerDTO {
    AddressDTO idAddres;
    String email;
    String firstName;
    String lastName;
    GenderDTO gender;
    Instant birthdate;
    double annualSalary;
    EmploymentContractDTO employmentContract;
    double firstDeposit;
    int phoneNumber;
    double requiredInterest;
    double requiredDuration;
    double monthlyRefund;
    double debtRatio;

    public BorrowerDTO(AddressDTO idAddres, String email, String firstName, String lastName, GenderDTO gender, Instant birthdate, double annualSalary,
                       EmploymentContractDTO employmentContract, double firstDeposit, int phoneNumber, double requiredInterest, double requiredDuration,
                       double monthlyRefund, double debtRatio) {
        this.idAddres = idAddres;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.annualSalary = annualSalary;
        this.employmentContract = employmentContract;
        this.firstDeposit = firstDeposit;
        this.phoneNumber = phoneNumber;
        this.requiredInterest = requiredInterest;
        this.requiredDuration = requiredDuration;
        this.monthlyRefund = monthlyRefund;
        this.debtRatio = debtRatio;
    }

    /* Getters & Setters */
    public AddressDTO getIdAddres() {
        return idAddres;
    }

    public void setIdAddres(AddressDTO idAddres) {
        this.idAddres = idAddres;
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

    public GenderDTO getGender() {
        return gender;
    }

    public void setGender(GenderDTO gender) {
        this.gender = gender;
    }

    public Instant getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Instant birthdate) {
        this.birthdate = birthdate;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public EmploymentContractDTO getEmploymentContract() {
        return employmentContract;
    }

    public void setEmploymentContract(EmploymentContractDTO employmentContract) {
        this.employmentContract = employmentContract;
    }

    public double getFirstDeposit() {
        return firstDeposit;
    }

    public void setFirstDeposit(double firstDeposit) {
        this.firstDeposit = firstDeposit;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getRequiredInterest() {
        return requiredInterest;
    }

    public void setRequiredInterest(double requiredInterest) {
        this.requiredInterest = requiredInterest;
    }

    public double getRequiredDuration() {
        return requiredDuration;
    }

    public void setRequiredDuration(double requiredDuration) {
        this.requiredDuration = requiredDuration;
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
}
