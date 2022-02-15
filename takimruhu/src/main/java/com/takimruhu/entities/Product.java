package com.takimruhu.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.List;
@Entity
@Table(name="Products")
public class Product {
    @Id
    private int productId;

    private String productName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="brand_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Brand brandId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="team_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Team teamId;//add relation

    private enum size{Small,Medium,Large}
    private boolean onSale;
    private boolean specialProduct;
    private int saleRate;
    private int numberOfStock;
    private double price;

    //constructor
    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public boolean isSpecialProduct() {
        return specialProduct;
    }

    public void setSpecialProduct(boolean specialProduct) {
        this.specialProduct = specialProduct;
    }

    public int getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(int saleRate) {
        this.saleRate = saleRate;
    }

    public int getNumberOfStock() {
        return numberOfStock;
    }

    public void setNumberOfStock(int numberOfStock) {
        this.numberOfStock = numberOfStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
