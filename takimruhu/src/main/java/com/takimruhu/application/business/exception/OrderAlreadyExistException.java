package com.takimruhu.application.business.exception;

@SuppressWarnings("serial")
public class OrderAlreadyExistException extends RuntimeException {
    public OrderAlreadyExistException() {
        super("Order already exists.");
    }
}
