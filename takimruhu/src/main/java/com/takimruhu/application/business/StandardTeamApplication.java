package com.takimruhu.application.business;

import com.takimruhu.application.TeamApplication;
import com.takimruhu.application.business.exception.TeamAlreadyExistException;
import com.takimruhu.application.business.exception.TeamNotFoundException;
import com.takimruhu.dto.request.team.AcquireTeamRequest;
import com.takimruhu.dto.request.team.UpdateTeamRequest;
import com.takimruhu.dto.response.team.*;
import com.takimruhu.entities.Team;
import com.takimruhu.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class StandardTeamApplication implements TeamApplication {

    private TeamRepository teamJpaRepository;
    private ModelMapper modelMapper;

    public StandardTeamApplication(TeamRepository teamJpaRepository, ModelMapper modelMapper) {
        this.teamJpaRepository = teamJpaRepository;
        this.modelMapper = modelMapper;
        System.err.println(this.teamJpaRepository.getClass().getName());
    }

    @Override
    public List<Team> getAllTeams() {
        return null;
    }

    @Override
    public DetailedTeamResponse findTeamById(int teamId) {
        var team = teamJpaRepository.findById(teamId).orElseThrow(() -> new TeamNotFoundException());
        var detailedTeamResponse = modelMapper.map(team, DetailedTeamResponse.class);
        return detailedTeamResponse;
    }

    @Override
    @Transactional
    public AcquireTeamResponse addTeam(AcquireTeamRequest request) {
        var identity = request.getId();
        if (teamJpaRepository.existsById(Integer.valueOf(identity)))
            throw new TeamAlreadyExistException();
        var team = modelMapper.map(request, Team.class);
        return modelMapper.map(teamJpaRepository.save(team),
                AcquireTeamResponse.class);
    }

    @Override
    @Transactional
    public UpdateTeamResponse updateTeam(int teamId, UpdateTeamRequest request) {
        var managedTeam = teamJpaRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException());
        managedTeam.setTeamName(request.getName());
        teamJpaRepository.save(managedTeam);
        var updateTeamResponse = modelMapper.map(managedTeam, UpdateTeamResponse.class);
        return updateTeamResponse;
    }

    @Override
    @Transactional
    public PatchTeamResponse patchTeam(int teamId, Map<Integer, Object> request) {
        var managedTeam = teamJpaRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException());
        for (var entry : request.entrySet()) {
            var attribute = entry.getKey();
            var value = entry.getValue();
            System.err.println(entry);
            try {
                var field = Team.class.getDeclaredField(String.valueOf(attribute));
                field.setAccessible(true);
                field.set(managedTeam, value);
                field.setAccessible(false);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                System.err.println(e.getMessage());
            }
        }
        return modelMapper.map(managedTeam, PatchTeamResponse.class);
    }

    @Override
    @Transactional
    public DeleteTeamResponse deleteTeamById(int teamId) {
        var managedTeam = teamJpaRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException());
        teamJpaRepository.delete(managedTeam);
        return modelMapper.map(managedTeam, DeleteTeamResponse.class);
    }
}
