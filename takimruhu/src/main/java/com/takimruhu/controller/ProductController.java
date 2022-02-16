package com.takimruhu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takimruhu.entities.Product;
import com.takimruhu.application.business.StandardProductApplication;

@RestController
@RequestMapping("products")
public class ProductController
{
    private StandardProductApplication productService;

    public ProductController(StandardProductApplication productService)
    {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product newProduct)
    {
        return productService.saveOneProduct(newProduct);
    }

    @GetMapping("/{productId}")
    public Product getProductByproductId(@PathVariable int productId)
    {
        return productService.getOneProduct(productId);
    }

    @PutMapping("/{productId}")
    public Product updateProductByproductId(@PathVariable int productId, @RequestBody Product newProduct)
    {
        return productService.updateOneProduct(productId,newProduct);
    }
    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable int productId)
    {
        productService.deleteById(productId);
    }

}