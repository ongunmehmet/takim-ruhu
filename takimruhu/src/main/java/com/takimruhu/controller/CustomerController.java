package com.takimruhu.controller;

import java.util.List;
import java.util.Map;

import com.takimruhu.application.CustomerApplication;
import com.takimruhu.application.business.exception.CustomerAlreadyExistException;
import com.takimruhu.dto.request.customer.AcquireCustomerRequest;
import com.takimruhu.dto.request.customer.UpdateCustomerRequest;
import com.takimruhu.dto.response.customer.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.takimruhu.entities.Customer;
import com.takimruhu.application.business.StandardCustomerApplication;

@RestController
@RequestMapping("customers")
public class CustomerController
{
    private CustomerApplication customerApplication;

    public CustomerController(CustomerApplication customerApplication) {
        this.customerApplication = customerApplication;
        System.err.println(customerApplication.getClass().getName());
    }

    public  void initRolesAndUsers(){
        customerApplication.initRolesAndUser();

    }

    // GET /customers/11111111110
    @GetMapping("{customerId}")
    public DetailedCustomerResponse getCustomerByIdentity(@PathVariable int customerId) {
        return customerApplication.findCustomerByIdentity(customerId);
    }

    @PostMapping
    public AcquireCustomerResponse acquireCustomer(@RequestBody @Validated AcquireCustomerRequest request) throws CustomerAlreadyExistException {
        return customerApplication.addCustomer(request);
    }

    @PutMapping("{customerId}")
    public UpdateCustomerResponse updateCustomer(@PathVariable @Validated int customerId,
                                                 @RequestBody @Validated UpdateCustomerRequest request) {
        return customerApplication.updateCustomer(customerId, request);
    }

    @PatchMapping("{customerId}")
    public PatchCustomerResponse patchCustomer(@PathVariable @Validated int customerId,
                                               @RequestBody Map<String, Object> changes) {
        return customerApplication.patchCustomer(customerId, changes);
    }

    @DeleteMapping("{customerId}")
    public DeleteCustomerResponse releaseCustomerByIdentity(@PathVariable int customerId) {
        return customerApplication.removeCustomerByIdentity(customerId);
    }
}