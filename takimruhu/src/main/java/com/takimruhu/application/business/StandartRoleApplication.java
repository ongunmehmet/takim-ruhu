package com.takimruhu.application.business;

import com.takimruhu.application.RoleApplication;
import com.takimruhu.entities.Customer;
import com.takimruhu.entities.Role;
import com.takimruhu.repository.CustomerRepository;
import com.takimruhu.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StandartRoleApplication implements RoleApplication {

    private RoleRepository roleRepository;
    private CustomerRepository customerRepository;

    public StandartRoleApplication(RoleRepository roleRepository,CustomerRepository customerRepository) {
        this.roleRepository = roleRepository;
        this.customerRepository=customerRepository;
    }

    public Role createNewRole(Role role){
        return roleRepository.save(role);

    }

}
