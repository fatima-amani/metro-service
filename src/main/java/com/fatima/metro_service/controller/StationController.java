package com.fatima.metro_service.controller;

import com.fatima.metro_service.model.Station;
import com.fatima.metro_service.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {
    @Autowired
    private StationService stationService;

    @GetMapping
    public List<Station> getStations() {
        return stationService.getAllStations();
    }
}

