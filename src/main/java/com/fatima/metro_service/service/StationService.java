package com.fatima.metro_service.service;

import com.fatima.metro_service.model.Station;
import com.fatima.metro_service.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StationService {
    @Autowired
    private StationRepository stationRepository;

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public String getStationEmail(Long id) {
        Optional<Station> station = stationRepository.findById(id);
        return station.map(Station::getStationEmail)
                .orElseThrow(() -> new RuntimeException("Station Email not found"));
    }

    public String getStationName(Long id) {
        Optional<Station> station = stationRepository.findById(id);
        return station.map(Station::getName)
                .orElseThrow(() -> new RuntimeException("Station Name not found"));
    }

}

