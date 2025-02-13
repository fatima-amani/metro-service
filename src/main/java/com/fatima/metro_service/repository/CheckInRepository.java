package com.fatima.metro_service.repository;

import com.fatima.metro_service.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
}

