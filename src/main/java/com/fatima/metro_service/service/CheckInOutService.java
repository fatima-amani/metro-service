package com.fatima.metro_service.service;

import com.fatima.metro_service.model.CheckIn;
import com.fatima.metro_service.model.CheckOut;
import com.fatima.metro_service.repository.CheckInRepository;
import com.fatima.metro_service.repository.CheckOutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckInOutService {
    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private CheckOutRepository checkOutRepository;

    public String checkIn(CheckIn checkIn) {
        checkIn.setCheckInTime(java.time.LocalDateTime.now());
        checkInRepository.save(checkIn);
        return "Check-in successful";
    }

    public String checkOut(CheckOut checkOut) {
        checkOut.setCheckOutTime(java.time.LocalDateTime.now());
        checkOutRepository.save(checkOut);
        return "Check-out successful";
    }
}