package com.takimruhu.service;

import com.takimruhu.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer saveOneCustomer(Customer newCustomer);
    Customer getOneCustomer(int customerId);
    Customer updateOneCustomer(int customerId, Customer newCustomer);
    void deleteById(int customerId);
}
