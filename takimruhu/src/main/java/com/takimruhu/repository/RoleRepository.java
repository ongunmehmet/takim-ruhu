package com.takimruhu.repository;

import com.takimruhu.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String > {
}
