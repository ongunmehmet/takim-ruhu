package com.takimruhu.application.business.exception;
@SuppressWarnings("serial")
public class SeasonNotFoundException extends RuntimeException{

        public SeasonNotFoundException() {
            super("Cannot find the season");
        }
    }

