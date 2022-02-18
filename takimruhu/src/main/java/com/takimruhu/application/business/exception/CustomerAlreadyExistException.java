package com.takimruhu.application.business.exception;
@SuppressWarnings("serial")
public class CustomerAlreadyExistException extends Throwable {
    public CustomerAlreadyExistException() {
        super("Customer already exists.");
    }
}
