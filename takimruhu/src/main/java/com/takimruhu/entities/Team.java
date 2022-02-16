package com.takimruhu.entities;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name="Teams")
@DynamicUpdate
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;

    private String teamName;

    public Team() {
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
