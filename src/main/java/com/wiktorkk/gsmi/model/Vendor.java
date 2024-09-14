package com.wiktorkk.gsmi.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String companyName;
    private String vatNumber;
    private String address;
    private String city;
    private String email;
    private String phone;
    private String bankAccount1;
    private String bankAccount2;
    private String bankAccount3;
    private String additionalInformation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Vendor() {
    }

    public Vendor(Long id, String companyName, String vatNumber, String address, String city, String email, String phone, String bankAccount1, String bankAccount2, String bankAccount3, String additionalInformation) {
        this.id = id;
        this.companyName = companyName;
        this.vatNumber = vatNumber;
        this.address = address;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.bankAccount1 = bankAccount1;
        this.bankAccount2 = bankAccount2;
        this.bankAccount3 = bankAccount3;
        this.additionalInformation = additionalInformation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankAccount1() {
        return bankAccount1;
    }

    public void setBankAccount1(String bankAccount1) {
        this.bankAccount1 = bankAccount1;
    }

    public String getBankAccount2() {
        return bankAccount2;
    }

    public void setBankAccount2(String bankAccount2) {
        this.bankAccount2 = bankAccount2;
    }

    public String getBankAccount3() {
        return bankAccount3;
    }

    public void setBankAccount3(String bankAccount3) {
        this.bankAccount3 = bankAccount3;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }


}
