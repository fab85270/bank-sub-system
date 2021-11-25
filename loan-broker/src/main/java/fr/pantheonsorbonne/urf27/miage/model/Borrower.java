package fr.pantheonsorbonne.urf27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.Instant;

@Entity
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowerId", nullable = false)
    private Integer borrowerId;

    @OneToOne(optional = true)
    @JoinColumn(name = "addressId", nullable = true)
    private Address addressId;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name="gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birthdate", nullable = false)
    private Instant birthdate;

    @Column(name="employmentContract", nullable = false)
    @Enumerated(EnumType.STRING)
    private Contract employmentContract;

    @Column(name = "annualSalary", nullable = false)
    private double annualSalary;

    @Column(name = "firstDeposit", nullable = false)
    private double firstDeposit;

    @Column(name = "phoneNumber", nullable = false, length = 10)
    private Integer phoneNumber;

    @Column(name = "requiredInterest", nullable = false)
    private double requiredInterest;

    @Column(name = "requiredDuration", nullable = false)
    private int requiredDuration;

    @Column(name = "monthlyRefund", nullable = false)
    private double monthlyRefund;

    @Column(name = "debtRatio", nullable = false)
    private double debtRatio;

    public Borrower() {
    }

    public Borrower(String firstName, String lastName, Instant birthdate, Gender gender, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.email = email;
    }

    public Borrower(Address addressId, String email, String firstName, String lastName, Gender gender, Instant birthdate, Contract employmentContract, double annualSalary, double firstDeposit, Integer phoneNumber, double requiredInterest, int requiredDuration, double monthlyRefund, double debtRatio) {
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
        this.requiredDuration = requiredDuration;
        this.monthlyRefund = monthlyRefund;
        this.debtRatio = debtRatio;
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Instant getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Instant birthdate) {
        this.birthdate = birthdate;
    }

    public Contract getEmploymentContract() {
        return employmentContract;
    }

    public void setEmploymentContract(Contract employmentContract) {
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getRequiredInterest() {
        return requiredInterest;
    }

    public void setRequiredInterest(double requiredInterest) {
        this.requiredInterest = requiredInterest;
    }

    public int getRequiredDuration() {
        return requiredDuration;
    }

    public void setRequiredDuration(int requiredDuration) {
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
