package com.takimruhu.application.business;

import com.takimruhu.application.CustomerApplication;
import com.takimruhu.application.business.exception.CustomerAlreadyExistException;
import com.takimruhu.application.business.exception.CustomerNotFoundException;
import com.takimruhu.dto.request.customer.AcquireCustomerRequest;
import com.takimruhu.dto.request.customer.UpdateCustomerRequest;
import com.takimruhu.dto.response.customer.*;
import com.takimruhu.entities.Customer;
import com.takimruhu.entities.Role;
import com.takimruhu.entities.Sex;
import com.takimruhu.repository.CustomerRepository;
import com.takimruhu.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class StandardCustomerApplication implements CustomerApplication
{
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public StandardCustomerApplication(CustomerRepository customerRepository, ModelMapper modelMapper, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public DetailedCustomerResponse findCustomerByIdentity(int identity) {
        var customer = customerRepository.findById(identity).orElseThrow(() -> new CustomerNotFoundException());
        var detailedCustomerResponse = modelMapper.map(customer, DetailedCustomerResponse.class);
       return detailedCustomerResponse;
    }


    @Override
    @Transactional
    public AcquireCustomerResponse addCustomer(AcquireCustomerRequest request) throws CustomerAlreadyExistException {
        var identity = request.getCustomerId();
        if (customerRepository.existsById(identity))
            throw new CustomerAlreadyExistException();
        var customer = modelMapper.map(request, Customer.class);
        return modelMapper.map(customerRepository.save(customer),
                AcquireCustomerResponse.class);
    }

    @Override
    @Transactional
    public UpdateCustomerResponse updateCustomer(int identity, UpdateCustomerRequest request) {
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
        managedCustomer.setTaxNo(request.getTaxNo());
        managedCustomer.setTaxDepartment(request.getTaxDepartment());

        customerRepository.save(managedCustomer);
        var updateCustomerResponse = modelMapper.map(managedCustomer, UpdateCustomerResponse.class);
        return updateCustomerResponse;
    }

    @Override
    @Transactional
    public PatchCustomerResponse patchCustomer(int identity, Map<String, Object> request) {
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
    public DeleteCustomerResponse removeCustomerByIdentity(int identity) {
        var managedCustomer = customerRepository.findById(identity)
                .orElseThrow(() -> new CustomerNotFoundException());
        customerRepository.delete(managedCustomer);
        return modelMapper.map(managedCustomer, DeleteCustomerResponse.class);
    }

    @Override
    public AcquireCustomerResponse findCustomerByEmail(String email) {
        var customer=customerRepository.findByEmail(email);
        return modelMapper.map(customer,AcquireCustomerResponse.class);
    }

    public void initRolesAndUser(){
        Role adminRole =new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("AdminRole");
        roleRepository.save(adminRole);

        Role userRole=new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default user role");
        roleRepository.save(userRole);

        Customer adminUser = new Customer();
        adminUser.setCustomerId(1);
        adminUser.setName("admin");
        adminUser.setEmail("admin@admin.com");
        adminUser.setPassword(getEncodedPassword("admin@password"));
        adminUser.setSex(Sex.MALE);
        Set<Role> adminRoles=new HashSet<>();
        adminUser.setRoles(adminRoles);
        adminRoles.add(adminRole);
        customerRepository.save(adminUser);

        Customer user = new Customer();
        user.setCustomerId(2);
        user.setName("admin");
        user.setEmail("user@user.com");
        user.setPassword(getEncodedPassword("user@password"));
        user.setSex(Sex.FEMALE);
        Set<Role> userRoles =new HashSet<>();
        userRoles .add(userRole);
        user.setRoles(userRoles);
        customerRepository.save(user);

    }

    public String getEncodedPassword(String password){
        return  passwordEncoder.encode(password);
    }


}