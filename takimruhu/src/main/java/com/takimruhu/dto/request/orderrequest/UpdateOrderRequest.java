package com.takimruhu.dto.request.orderrequest;

import javax.persistence.Id;

public class UpdateOrderRequest {

    private long timeStamp;
    private int productId;
    private int cargoId;
    private String address;

    public UpdateOrderRequest() {
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
