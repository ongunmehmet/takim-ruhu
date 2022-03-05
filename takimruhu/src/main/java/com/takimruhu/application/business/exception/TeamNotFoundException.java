package com.takimruhu.application.business.exception;
@SuppressWarnings("serial")
public class TeamNotFoundException extends RuntimeException {

        public TeamNotFoundException() {
            super("Cannot find the team");
        }

}
