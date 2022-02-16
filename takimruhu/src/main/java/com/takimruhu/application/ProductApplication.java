package com.takimruhu.application;

import com.takimruhu.entities.Customer;
import com.takimruhu.entities.Product;

import java.util.List;

public interface ProductApplication {
    List<Product> getAllProducts();
    Product saveOneProduct(Product newProduct);
    Product getOneProduct(int ProductId);
    Product updateOneProduct(int ProductId, Product newProduct);
    void deleteById(int ProductId);
}
