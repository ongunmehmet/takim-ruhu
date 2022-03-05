package com.takimruhu.application.business;

import com.takimruhu.application.SeasonApplication;
import com.takimruhu.application.business.exception.SeasonAlreadyExistException;
import com.takimruhu.application.business.exception.SeasonNotFoundException;
import com.takimruhu.dto.request.season.AcquireSeasonRequest;
import com.takimruhu.dto.request.season.UpdateSeasonRequest;
import com.takimruhu.dto.response.season.*;
import com.takimruhu.entities.Season;
import com.takimruhu.repository.SeasonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class StandardSeasonApplication implements SeasonApplication {

    private SeasonRepository seasonJpaRepository;
    private ModelMapper modelMapper;

    public StandardSeasonApplication(SeasonRepository seasonJpaRepository, ModelMapper modelMapper) {
        this.seasonJpaRepository = seasonJpaRepository;
        this.modelMapper = modelMapper;
        System.err.println(this.seasonJpaRepository.getClass().getName());
    }

    @Override
    public List<Season> getAllSeasons() {
        return null;
    }

    @Override
    public DetailedSeasonResponse findSeasonById(int seasonId) {
        var season = seasonJpaRepository.findById(seasonId).orElseThrow(() -> new SeasonNotFoundException());
        var detailedSeasonResponse = modelMapper.map(season, DetailedSeasonResponse.class);
        return detailedSeasonResponse;    }

    @Override
    @Transactional
    public AcquireSeasonResponse addSeason(AcquireSeasonRequest request) {
        var identity = request.getSeasonId();
        if (seasonJpaRepository.existsById(Integer.valueOf(identity)))
            throw new SeasonAlreadyExistException();
        var season = modelMapper.map(request, Season.class);
        return modelMapper.map(seasonJpaRepository.save(season),
                AcquireSeasonResponse.class);    }

    @Override
    @Transactional
    public UpdateSeasonResponse updateSeason(int seasonId, UpdateSeasonRequest request) {
        var managedSeason = seasonJpaRepository.findById(seasonId)
                .orElseThrow(() -> new SeasonNotFoundException());
        managedSeason.setSeasonName(request.getName());
        seasonJpaRepository.save(managedSeason);
        var updateSeasonResponse = modelMapper.map(managedSeason, UpdateSeasonResponse.class);
        return updateSeasonResponse;    }

    @Override
    @Transactional
    public PatchSeasonResponse patchSeason(int seasonId, Map<Integer, Object> request) {
        var managedSeason = seasonJpaRepository.findById(seasonId)
                .orElseThrow(() -> new SeasonNotFoundException());
        for (var entry : request.entrySet()) {
            var attribute = entry.getKey();
            var value = entry.getValue();
            System.err.println(entry);
            try {
                var field = Season.class.getDeclaredField(String.valueOf(attribute));
                field.setAccessible(true);
                field.set(managedSeason, value);
                field.setAccessible(false);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                System.err.println(e.getMessage());
            }
        }
        return modelMapper.map(managedSeason, PatchSeasonResponse.class);
    }

    @Override
    @Transactional
    public DeleteSeasonResponse deleteSeasonById(int seasonId) {
        var managedSeason = seasonJpaRepository.findById(seasonId)
                .orElseThrow(() -> new SeasonNotFoundException());
        seasonJpaRepository.delete(managedSeason);
        return modelMapper.map(managedSeason, DeleteSeasonResponse.class);
    }
}
