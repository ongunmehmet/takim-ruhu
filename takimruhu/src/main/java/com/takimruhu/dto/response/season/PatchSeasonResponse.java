package com.takimruhu.dto.response.season;

public class PatchSeasonResponse {
    private String name;
    private int year;

    public PatchSeasonResponse() {
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
