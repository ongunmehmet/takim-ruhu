package com.takimruhu.dto.request.orderrequest;

public class AddOrderRequest {
    private int orderId;
    private int customerId;
    private long timeStamp;
    private int productId;
    private double orderAmount;
    private int cargoId;
    private String address;

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public int getProductId() {
        return productId;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public int getCargoId() {
        return cargoId;
    }

    public String getAddress() {
        return address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public AddOrderRequest() {
    }
}
