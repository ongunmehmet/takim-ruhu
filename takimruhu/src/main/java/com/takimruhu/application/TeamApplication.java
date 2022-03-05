package com.takimruhu.application;

import com.takimruhu.dto.request.team.AcquireTeamRequest;
import com.takimruhu.dto.request.team.UpdateTeamRequest;
import com.takimruhu.dto.response.team.*;
import com.takimruhu.entities.Team;

import java.util.List;
import java.util.Map;

public interface TeamApplication {

    List<Team> getAllTeams();

    DetailedTeamResponse findTeamById(int teamId);

    AcquireTeamResponse addTeam(AcquireTeamRequest request);

    UpdateTeamResponse updateTeam(int teamId, UpdateTeamRequest request);

    PatchTeamResponse patchTeam(int teamId, Map<Integer, Object> changes);

    DeleteTeamResponse deleteTeamById(int teamId);

}