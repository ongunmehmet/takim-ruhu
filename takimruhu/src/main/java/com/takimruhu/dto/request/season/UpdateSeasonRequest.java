package com.takimruhu.dto.request.season;

public class UpdateSeasonRequest {
    private String name;
    private int year;

    public UpdateSeasonRequest() {
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
