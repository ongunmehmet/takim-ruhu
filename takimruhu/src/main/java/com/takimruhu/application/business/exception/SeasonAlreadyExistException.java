package com.takimruhu.application.business.exception;
@SuppressWarnings("serial")
public class SeasonAlreadyExistException extends RuntimeException{
        public SeasonAlreadyExistException() {
            super("Season already exists.");
        }
}
