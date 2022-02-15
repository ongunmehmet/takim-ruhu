package com.takimruhu.dto.request.team;

public class AcquireTeamRequest {
    private String name;
    private String id;

    public AcquireTeamRequest() {
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
