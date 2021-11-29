package loan.bank.model;


import org.javamoney.moneta.Money;

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

    @Column(name = "annualSalary", nullable = false)
    private double annualSalary;

    @Column(name = "firstDeposit", nullable = false)
    private double firstDeposit;

    @Column(name = "phoneNumber", nullable = false, length = 10)
    private Integer phoneNumber;

    @Column(name = "debtRatio", nullable = false)
    private double debtRatio; //taux d'endettement

    public Borrower() {
    }

    public Borrower(String firstName, String lastName, LocalDate birthdate, Gender gender, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
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

    public double getDebtRatio() {
        return debtRatio;
    }

    public void setDebtRatio(double debtRatio) {
        this.debtRatio = debtRatio;
    }
}
