package com.fatima.metro_service.controller;

import com.fatima.metro_service.model.CheckIn;
import com.fatima.metro_service.model.CheckOut;
import com.fatima.metro_service.service.CheckInOutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/check")
@Slf4j
public class CheckInOutController {
    @Autowired
    private CheckInOutService checkInOutService;

    @PostMapping("/in")
    public ResponseEntity<String> checkIn(@RequestBody CheckIn checkIn) {
        log.info("Checking in");
        String message = checkInOutService.checkIn(checkIn);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/out")
    public ResponseEntity<String> checkOut(@RequestBody CheckOut checkOut) {
        log.info("Checking out");
        String message = checkInOutService.checkOut(checkOut);
        return ResponseEntity.ok(message);
    }
}
