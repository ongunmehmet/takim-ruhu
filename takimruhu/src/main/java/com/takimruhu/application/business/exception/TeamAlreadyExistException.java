package com.takimruhu.application.business.exception;
@SuppressWarnings("serial")
public class TeamAlreadyExistException extends RuntimeException{
    public TeamAlreadyExistException() {
        super("Team already exists.");
    }
}
