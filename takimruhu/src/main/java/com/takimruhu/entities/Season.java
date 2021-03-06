package com.takimruhu.entities;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="seasons")
@DynamicUpdate
public class Season {
    @Id
    @Column(name = "season_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seasonId;
    private String seasonName;

    public Season() {

    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Season season = (Season) o;
        return seasonId == season.seasonId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seasonId);
    }


}
