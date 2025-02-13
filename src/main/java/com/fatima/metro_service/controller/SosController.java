package com.fatima.metro_service.controller;

import com.fatima.metro_service.service.SosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sos")
@RequiredArgsConstructor
public class SosController {

    private final SosService sosService;

    @PostMapping("/{userId}/{station}")
    public ResponseEntity<String> triggerSOS(@PathVariable Long userId, @PathVariable String station) {
        sosService.triggerSOS(userId, station);
        return ResponseEntity.ok("SOS Alert Triggered");
    }
}
