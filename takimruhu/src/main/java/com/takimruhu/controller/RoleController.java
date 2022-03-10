package com.takimruhu.controller;

import com.takimruhu.application.RoleApplication;
import com.takimruhu.entities.Role;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    private RoleApplication roleApplication;

    public RoleController(RoleApplication roleApplication) {
        this.roleApplication = roleApplication;
    }

    @PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role){
        return roleApplication.createNewRole(role);

    }

}
