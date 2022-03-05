package com.takimruhu.dto.response.jwt;

import com.takimruhu.entities.Customer;

public class JwtResponse {
    private Customer customer;
    private String jwtToken;

    public JwtResponse() {
    }

    public JwtResponse(Customer user, String newGeneratedToken) {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
