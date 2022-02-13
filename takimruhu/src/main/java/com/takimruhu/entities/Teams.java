package com.takimruhu.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teams {
    @Id
    private int teamId;
    private String teamName;


    public Teams() {
    }

    public int getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


}
