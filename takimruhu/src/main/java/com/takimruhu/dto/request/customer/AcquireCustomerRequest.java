package com.takimruhu.dto.request.customer;

import com.takimruhu.entities.Sex;
import org.hibernate.mapping.List;
import org.hibernate.mapping.Map;

public class AcquireCustomerRequest {
    private int customerId;
    private String name;
    private String surName;
    private String Email;
    private String password;
    private Sex sex;
    private String phoneNumber;
    private boolean isAdmin;
    private Map adresses;
    private List favoredProducts;
    private String companyName;
    private String taxNo;
    private String taxDepartment;


    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getTaxDepartment() {
        return taxDepartment;
    }

    public void setTaxDepartment(String taxDepartment) {
        this.taxDepartment = taxDepartment;
    }

    public AcquireCustomerRequest() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Map getAdresses() {
        return adresses;
    }

    public void setAdresses(Map adresses) {
        this.adresses = adresses;
    }

    public List getFavoredProducts() {
        return favoredProducts;
    }

    public void setFavoredProducts(List favoredProducts) {
        this.favoredProducts = favoredProducts;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "AcquireCustomerRequest{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isAdmin=" + isAdmin +
                ", adresses=" + adresses +
                ", favoredProducts=" + favoredProducts +
                ", companyName='" + companyName + '\'' +
                ", taxNo='" + taxNo + '\'' +
                ", taxDepartment='" + taxDepartment + '\'' +
                '}';
    }
}
