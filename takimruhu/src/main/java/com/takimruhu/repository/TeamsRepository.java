package com.takimruhu.repository;

import com.takimruhu.dto.entities.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository extends JpaRepository <Teams,Integer> {

}
