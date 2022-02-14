package com.takimruhu.application.business;

import java.util.List;
import java.util.Optional;

import com.takimruhu.entities.Customer;
import com.takimruhu.repository.CustomerRepository;
import org.springframework.stereotype.Service;



@Service
public class CustomerService
{
    CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        super();
        this.customerRepository = customerRepository;
    }


    public List<Customer> getAllCustomers()
    {

        return customerRepository.findAll();
    }


    public Customer saveOneCustomer(Customer newCustomer)
    {

        return customerRepository.save(newCustomer);
    }


    public Customer getOneCustomer(int customerId)
    {
        return customerRepository.findById(customerId).orElse(null);
    }


    public Customer updateOneCustomer(int customerId, Customer newCustomer)
    {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isPresent())
        {
            Customer foundCustomer = customer.get();
            foundCustomer.setCustomerId(newCustomer.getCustomerId());
            foundCustomer.setName(newCustomer.getName());
            foundCustomer.setSurName(newCustomer.getSurName());
            foundCustomer.setEmail(newCustomer.getEmail());
            foundCustomer.setPassword(newCustomer.getPassword());
            foundCustomer.setSex(newCustomer.getSex());
            foundCustomer.setPhoneNumber(newCustomer.getPhoneNumber());
            foundCustomer.setAdmin(newCustomer.isAdmin());
            foundCustomer.setAdresses(newCustomer.getAdresses());
            foundCustomer.setFavoredProducts(newCustomer.getFavoredProducts());
            foundCustomer.setCompanyName(newCustomer.getCompanyName());
            foundCustomer.setVergiNo(newCustomer.getVergiNo());
            foundCustomer.setVergiDairesi(newCustomer.getVergiDairesi());

            return foundCustomer;

        }else
            return null;
    }


    public void deleteById(int customerId)
    {
        customerRepository.deleteById(customerId);

    }

}