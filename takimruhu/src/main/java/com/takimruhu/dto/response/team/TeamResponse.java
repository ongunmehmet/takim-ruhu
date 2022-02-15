package com.takimruhu.dto.response.team;

public class TeamResponse {
    private String name;
    private String id;

    public TeamResponse() {
    }
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
