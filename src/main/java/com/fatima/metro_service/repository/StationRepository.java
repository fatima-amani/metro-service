package com.fatima.metro_service.repository;


import com.fatima.metro_service.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
}
