package com.fatima.metro_service.repository;

import com.fatima.metro_service.model.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckOutRepository extends JpaRepository<CheckOut, Long> {
}