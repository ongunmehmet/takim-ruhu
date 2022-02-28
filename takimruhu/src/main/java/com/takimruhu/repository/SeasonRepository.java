package com.takimruhu.repository;

import com.takimruhu.entities.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository <Season,Integer> {
}
