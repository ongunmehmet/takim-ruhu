package com.takimruhu.controller;

import com.takimruhu.application.SeasonApplication;
import com.takimruhu.application.business.exception.SeasonNotFoundException;
import com.takimruhu.dto.request.season.AcquireSeasonRequest;
import com.takimruhu.dto.request.season.UpdateSeasonRequest;
import com.takimruhu.dto.response.season.*;
import com.takimruhu.entities.Season;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("seasons")
@RestController
public class SeasonRestController {

    private SeasonApplication seasonApplication;

    public SeasonRestController(SeasonApplication seasonApplication) {
        this.seasonApplication = seasonApplication;
        System.err.println(seasonApplication.getClass().getName());
    }

    @GetMapping
    public List<Season> getAllSeasons() {return seasonApplication.getAllSeasons();}


    @GetMapping("{seasonId}")
    public DetailedSeasonResponse getSeasonById(@PathVariable int seasonId) throws SeasonNotFoundException {
        return seasonApplication.findSeasonById(seasonId);
    }

    @PostMapping
    public AcquireSeasonResponse acquireSeason(@RequestBody @Validated AcquireSeasonRequest request) throws SeasonNotFoundException {
        return seasonApplication.addSeason(request);
    }

    @PutMapping("{seasonId}")
    public UpdateSeasonResponse updateSeason(@PathVariable @Validated int seasonId,
                                             @RequestBody @Validated UpdateSeasonRequest request) throws SeasonNotFoundException {
        return seasonApplication.updateSeason(seasonId, request);
    }

    @PatchMapping("{seasonId}")
    public PatchSeasonResponse patchSeason (@PathVariable int seasonId, @RequestBody Map<Integer, Object> changes) throws SeasonNotFoundException{
        return seasonApplication.patchSeason(seasonId, changes);
    }

    @DeleteMapping("{seasonId}")
    public DeleteSeasonResponse deleteSeasonById(@PathVariable int seasonId) throws SeasonNotFoundException {
        return seasonApplication.deleteSeasonById(seasonId);
    }
}
