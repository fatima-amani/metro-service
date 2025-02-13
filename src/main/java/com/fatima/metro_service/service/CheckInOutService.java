package com.fatima.metro_service.service;

import com.fatima.metro_service.model.CheckIn;
import com.fatima.metro_service.model.CheckOut;
import com.fatima.metro_service.repository.CheckInRepository;
import com.fatima.metro_service.repository.CheckOutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class CheckInOutService {
    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private CheckOutRepository checkOutRepository;

    @Autowired
    private RedisService redisService;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public String checkIn(CheckIn checkIn) {
        checkIn.setCheckInTime(java.time.LocalDateTime.now());
        checkInRepository.save(checkIn);
        redisService.addActiveUser(String.valueOf(checkIn.getUserId()));
        return "Check-in successful";
    }

    public String checkOut(CheckOut checkOut) {
        checkOut.setCheckOutTime(java.time.LocalDateTime.now());
        checkOutRepository.save(checkOut);
        redisService.removeActiveUser(String.valueOf(checkOut.getUserId()));
        double fare = calculateFare(checkOut.getUserId());
        sendFareToPaymentService(checkOut.getUserId(), fare);
        return "Check-out successful";
    }

    private double calculateFare(Long userId) {
        CheckIn checkIn = checkInRepository.findByUserId(userId);
        Duration duration = Duration.between(checkIn.getCheckInTime(), LocalDateTime.now());
        double baseFare = 30; // Example base fare
        if (duration.toMinutes() > 90) {
            baseFare += 20; // Add penalty if user exceeds 90 minutes
        }
        return baseFare;
    }

    private void sendFareToPaymentService(Long userId, double fare) {
        Map<String, Object> paymentData = new HashMap<>();
        paymentData.put("userId", userId);
        paymentData.put("fare", fare);
        kafkaTemplate.send("fare_payment", paymentData.toString());
    }
}