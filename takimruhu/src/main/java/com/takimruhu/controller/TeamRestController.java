package com.takimruhu.controller;

import com.takimruhu.application.TeamApplication;
import com.takimruhu.application.business.exception.TeamNotFoundException;
import com.takimruhu.dto.request.team.AcquireTeamRequest;
import com.takimruhu.dto.request.team.UpdateTeamRequest;
import com.takimruhu.dto.response.team.*;
import com.takimruhu.entities.Team;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;
import java.util.Map;


@RequestMapping("teams")
@RestController
public class TeamRestController {

    private TeamApplication teamApplication;

    public TeamRestController(TeamApplication teamApplication) {
        this.teamApplication = teamApplication;
        System.err.println(teamApplication.getClass().getName());
    }

    @GetMapping
    public List<Team> getAllTeams() {return teamApplication.getAllTeams();}


    @GetMapping("{teamId}")
    public DetailedTeamResponse getTeamById(@PathVariable int teamId) throws TeamNotFoundException {
        return teamApplication.findTeamById(teamId);
    }


    @PostMapping
    public AcquireTeamResponse acquireTeam(@RequestBody @Validated AcquireTeamRequest request) throws TeamNotFoundException {
        return teamApplication.addTeam(request);
    }

    @PutMapping("{teamId}")
    public UpdateTeamResponse updateTeam(@PathVariable @Validated int teamId,
                                             @RequestBody @Validated UpdateTeamRequest request) throws TeamNotFoundException {
        return teamApplication.updateTeam(teamId, request);
    }

    @PatchMapping("{teamId}")
    public PatchTeamResponse patchTeam (@PathVariable int teamId, @RequestBody Map<Integer, Object> changes) throws TeamNotFoundException{
        return teamApplication.patchTeam(teamId, changes);
    }

    @DeleteMapping("{teamId}")
    public DeleteTeamResponse deleteTeamById(@PathVariable int teamId) throws TeamNotFoundException {
        return teamApplication.deleteTeamById(teamId);
    }

    }

