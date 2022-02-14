package com.takimruhu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takimruhu.entities.Customer;
import com.takimruhu.business.CustomerService;

@RestController
@RequestMapping("customers")
public class CustomerController
{
    private CustomerService customerService;

    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer newCustomer)
    {
        return customerService.saveOneCustomer(newCustomer);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerBycustomerId(@PathVariable int customerId)
    {
        return customerService.getOneCustomer(customerId);
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomerBycustomerId(@PathVariable int customerId, @RequestBody Customer newCustomer)
    {
        return customerService.updateOneCustomer(customerId,newCustomer);
    }
    @DeleteMapping("/{customerId}")
    public void deleteCustomerById(@PathVariable int customerId)
    {
        customerService.deleteById(customerId);
    }

}