package com.fatima.metro_service.controller;

import com.fatima.metro_service.model.CheckIn;
import com.fatima.metro_service.model.CheckOut;
import com.fatima.metro_service.service.CheckInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/check")
public class CheckInOutController {
    @Autowired
    private CheckInOutService checkInOutService;

    @PostMapping("/in")
    public ResponseEntity<String> checkIn(@RequestBody CheckIn checkIn) {
        String message = checkInOutService.checkIn(checkIn);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/out")
    public ResponseEntity<String> checkOut(@RequestBody CheckOut checkOut) {
        String message = checkInOutService.checkOut(checkOut);
        return ResponseEntity.ok(message);
    }
}
