package com.takimruhu.application;

import com.takimruhu.application.business.exception.CustomerAlreadyExistException;
import com.takimruhu.dto.request.customer.AcquireCustomerRequest;
import com.takimruhu.dto.request.customer.UpdateCustomerRequest;
import com.takimruhu.dto.response.customer.*;
import com.takimruhu.entities.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface CustomerApplication {


    DetailedCustomerResponse findCustomerByIdentity(int identity);

    @Transactional
    AcquireCustomerResponse addCustomer(AcquireCustomerRequest request) throws CustomerAlreadyExistException;

    @Transactional
    UpdateCustomerResponse updateCustomer(int identity, UpdateCustomerRequest request);

    @Transactional
    PatchCustomerResponse patchCustomer(int identity, Map<String, Object> request);

    @Transactional
    DeleteCustomerResponse removeCustomerByIdentity(int identity);
}
