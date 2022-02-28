package com.takimruhu.application;

import com.takimruhu.dto.request.season.AcquireSeasonRequest;
import com.takimruhu.dto.request.season.UpdateSeasonRequest;
import com.takimruhu.dto.response.season.*;
import com.takimruhu.entities.Season;

import java.util.List;
import java.util.Map;

public interface SeasonApplication {

    List<Season> getAllSeasons();

    DetailedSeasonResponse findSeasonById(int seasonId);

    AcquireSeasonResponse addSeason(AcquireSeasonRequest request);

    UpdateSeasonResponse updateSeason(int seasonId, UpdateSeasonRequest request);

    PatchSeasonResponse patchSeason(int seasonId, Map<Integer, Object> changes);

    DeleteSeasonResponse deleteSeasonById(int seasonId);
}
