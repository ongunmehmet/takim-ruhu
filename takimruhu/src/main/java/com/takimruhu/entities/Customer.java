package com.takimruhu.entities;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.mapping.List;
import org.hibernate.mapping.Map;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
@DynamicUpdate
public class Customer {
    @Id
    @Column(name = "customer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String name;
    private String surName;
    @Column(name="email",unique = true,nullable = false)
    private String Email;
    private String password;
    private Sex sex;
    private String phoneNumber;
    private boolean isAdmin;
    private Map addresses;
    private List favoredProducts;
    private String companyName;
    private String taxNo;
    private String taxDepartment;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="USER_ROLE",
            joinColumns = {@JoinColumn (name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name= "ROLE_ID")})
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public Map getAddresses() {
        return addresses;
    }

    public void setAddresses(Map addresses) {
        this.addresses = addresses;
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

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isAdmin=" + isAdmin +
                ", addresses=" + addresses +
                ", favoredProducts=" + favoredProducts +
                ", companyName='" + companyName + '\'' +
                ", taxNo='" + taxNo + '\'' +
                ", taxDepartment='" + taxDepartment + '\'' +
                '}';
    }
}