package com.takimruhu.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Order {
    @Id
    private int orderId;
    private long timeStamp;
    private int productId;
    private double orderAmount;
    private int cargoId;
    private String address;

    public Order() {
    }

    public int getOrderId() {

        return orderId;
    }

    public void setOrderId(int orderId) {

        this.orderId = orderId;
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

    public double getOrderAmount() {

        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {

        this.orderAmount = orderAmount;
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

    public void setAddress(String adress) {
        this.address = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", timeStamp=" + timeStamp +
                ", productId=" + productId +
                ", orderAmount=" + orderAmount +
                ", cargoId=" + cargoId +
                ", address='" + address + '\'' +
                '}';
    }
}
