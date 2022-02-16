package com.takimruhu.application.business.exception;

@SuppressWarnings("serial")
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException() {
        super("Cannot find the order");
    }
}
