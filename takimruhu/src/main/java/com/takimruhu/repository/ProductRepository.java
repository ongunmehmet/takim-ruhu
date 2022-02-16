package com.takimruhu.repository;

import com.takimruhu.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    Product findByName(String name);
}