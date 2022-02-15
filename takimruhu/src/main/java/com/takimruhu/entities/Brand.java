package com.takimruhu.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brand {
    @Id
    private int brandId;
    private String brandName;

    public int getBrandId() {
        return brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Brand() {
    }
}
