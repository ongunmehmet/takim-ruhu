package com.takimruhu.application.business;

import com.takimruhu.application.CustomerApplication;
import com.takimruhu.application.business.exception.CustomerAlreadyExistException;
import com.takimruhu.application.business.exception.CustomerNotFoundException;
import com.takimruhu.dto.request.customer.AcquireCustomerRequest;
import com.takimruhu.dto.request.customer.UpdateCustomerRequest;
import com.takimruhu.dto.response.customer.*;
import com.takimruhu.entities.Customer;
import com.takimruhu.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class StandardCustomerApplication implements CustomerApplication
{
    CustomerRepository customerRepository;
    private ModelMapper modelMapper;



    @Override
    public DetailedCustomerResponse findCustomerByIdentity(String identity) {
        var customer = customerRepository.findById(identity).orElseThrow(() -> new CustomerNotFoundException());
        var detailedCustomerResponse = modelMapper.map(customer, DetailedCustomerResponse.class);
       return detailedCustomerResponse;
    }


    @Override
    @Transactional
    public AcquireCustomerResponse addCustomer(AcquireCustomerRequest request) throws CustomerAlreadyExistException {
        var identity = request.getCustomerId();
        if (customerRepository.existsById(String.valueOf(identity)))//Neden String.valueof olmadan calısmıyor.
            throw new CustomerAlreadyExistException();
        var customer = modelMapper.map(request, Customer.class);
        return modelMapper.map(customerRepository.save(customer),
                AcquireCustomerResponse.class);
    }

    @Override
    @Transactional
    public UpdateCustomerResponse updateCustomer(String identity, UpdateCustomerRequest request) {
        var managedCustomer = customerRepository.findById(identity)
                .orElseThrow(() -> new CustomerNotFoundException());
        managedCustomer.setName(request.getName());
        managedCustomer.setSurName(request.getSurName());
        managedCustomer.setEmail(request.getEmail());
        managedCustomer.setPassword(request.getPassword());
        managedCustomer.setSex(request.getSex());
        managedCustomer.setPhoneNumber(request.getPhoneNumber());
        managedCustomer.setAdmin(request.isAdmin());
        managedCustomer.setAddresses(request.getAdresses());
        managedCustomer.setFavoredProducts(request.getFavoredProducts());
        managedCustomer.setCompanyName(request.getCompanyName());
        managedCustomer.setTaxNo(request.getVergiNo());
        managedCustomer.setTaxDepartment(request.getVergiDairesi());

        customerRepository.save(managedCustomer);
        var updateCustomerResponse = modelMapper.map(managedCustomer, UpdateCustomerResponse.class);
        return updateCustomerResponse;
    }

    @Override
    @Transactional
    public PatchCustomerResponse patchCustomer(String identity, Map<String, Object> request) {
        var managedCustomer = customerRepository.findById(identity)
                .orElseThrow(() -> new CustomerNotFoundException());
        for (var entry : request.entrySet()) {
            var attribute = entry.getKey();
            var value = entry.getValue();
            System.err.println(entry);
            try {
                var field = Customer.class.getDeclaredField(attribute);
                field.setAccessible(true);
                field.set(managedCustomer, value);
                field.setAccessible(false);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                System.err.println(e.getMessage());
            }
        }
        return modelMapper.map(managedCustomer, PatchCustomerResponse.class);
    }

    @Override
    @Transactional
    public DeleteCustomerResponse removeCustomerByIdentity(String identity) {
        var managedCustomer = customerRepository.findById(identity)
                .orElseThrow(() -> new CustomerNotFoundException());
        customerRepository.delete(managedCustomer);
        return modelMapper.map(managedCustomer, DeleteCustomerResponse.class);
    }




}