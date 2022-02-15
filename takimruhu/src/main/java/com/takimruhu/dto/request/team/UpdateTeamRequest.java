package com.takimruhu.dto.request.team;

public class UpdateTeamRequest {
        private String name;
        private String id;

        public UpdateTeamRequest() {
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
