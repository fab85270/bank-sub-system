package loan.bank.model;

import loan.bank.model.Address;
import loan.bank.model.EmploymentContract;
import loan.bank.model.Gender;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

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
    private LocalDate birthdate;

    @Column(name="employmentContract", nullable = false)
    @Enumerated(EnumType.STRING)
    private EmploymentContract employmentContract;

    @Column(name = "annualSalary", nullable = false)
    private double annualSalary;

    @Column(name = "firstDeposit", nullable = false)
    private double firstDeposit;

    @Column(name = "phoneNumber", nullable = false, length = 15)
    private String phoneNumber;

    @Column(name = "requiredInterest", nullable = false)
    private double requiredInterest;

    @Column(name = "monthlyRefund", nullable = false)
    private double monthlyRefund;

    @Column(name = "debtRatio", nullable = false)
    private double debtRatio;

    public Borrower() {
    }

    public Borrower(String firstName, String lastName, LocalDate birthdate, Gender gender, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.email = email;
    }

    public Borrower(Address addressId, String email, String firstName, String lastName, Gender gender, LocalDate birthdate,
                    EmploymentContract employmentContract, double annualSalary, double firstDeposit, String phoneNumber,
                    double requiredInterest, double monthlyRefund, double debtRatio) {
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public EmploymentContract getEmploymentContract() {
        return employmentContract;
    }

    public void setEmploymentContract(EmploymentContract employmentContract) {
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
        return "Borrower{" +
                "borrowerId=" + borrowerId +
                ", addressId=" + addressId +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", birthdate=" + birthdate +
                ", employmentContract=" + employmentContract +
                ", annualSalary=" + annualSalary +
                ", firstDeposit=" + firstDeposit +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", requiredInterest=" + requiredInterest +
                ", monthlyRefund=" + monthlyRefund +
                ", debtRatio=" + debtRatio +
                '}';
    }
}
