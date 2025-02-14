package com.fatima.metro_service.controller;

import com.fatima.metro_service.model.Station;
import com.fatima.metro_service.service.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")
@Slf4j
public class StationController {
    @Autowired
    private StationService stationService;

    @GetMapping
    public List<Station> getStations() {
        List<Station> stations = stationService.getAllStations();
        log.info("fetching active stations");
        if (stations.isEmpty()) {
            throw new RuntimeException("No Active Station");
        }
        return stations;
    }

    @GetMapping("/email/{id}")
    public String getStationEmail(@PathVariable Long id){
        log.info("fetching email for station: {}", id);
        return stationService.getStationEmail(id);
    }

    @GetMapping("/name/{id}")
    public String getStationName(@PathVariable Long id){
        log.info("fetching name for station: {}", id);
        return stationService.getStationName(id);
    }
}

