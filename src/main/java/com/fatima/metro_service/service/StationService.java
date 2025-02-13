package com.fatima.metro_service.service;

import com.fatima.metro_service.model.Station;
import com.fatima.metro_service.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StationService {
    @Autowired
    private StationRepository stationRepository;

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }
}

