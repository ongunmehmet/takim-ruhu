package com.takimruhu.dto.response.team;

public class DeleteTeamResponse {
    private String name;
    private String id;

    public DeleteTeamResponse() {
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
