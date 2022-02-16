package com.takimruhu.application.business;

import com.takimruhu.application.ProductApplication;
import com.takimruhu.entities.Customer;
import com.takimruhu.entities.Product;
import com.takimruhu.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandardProductApplication implements ProductApplication {
    ProductRepository productRepository;

    public StandardProductApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product saveOneProduct(Product newProduct) {

        return productRepository.save(newProduct);
    }

    @Override
    public Product getOneProduct(int productId) {

        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product updateOneProduct(int productId, Product newProduct) {

        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent())
        {
            Product foundProduct = product.get();

            foundProduct.setProductId((newProduct.getProductId()));
            foundProduct.setProductName(newProduct.getProductName());
            foundProduct.setBrandId(newProduct.getBrandId());
            foundProduct.setTeamId(newProduct.getTeamId());
            foundProduct.setOnSale((newProduct.isOnSale()));
            foundProduct.setSpecialProduct(newProduct.isSpecialProduct());
            foundProduct.setSaleRate(newProduct.getSaleRate());
            foundProduct.setNumberOfStock(newProduct.getNumberOfStock());
            foundProduct.setPrice(newProduct.getPrice());

            return foundProduct;

        }else
            return null;
    }

    @Override
    public void deleteById(int productId) {
        productRepository.deleteById(productId);

    }
}
