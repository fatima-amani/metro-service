package com.fatima.metro_service.controller;

import com.fatima.metro_service.service.SosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sos")
@RequiredArgsConstructor
@Slf4j
public class SosController {

    private final SosService sosService;

    @PostMapping("/{userId}/{stationId}")
    public ResponseEntity<String> triggerSOS(@PathVariable Long userId, @PathVariable Long stationId) {
        log.info("Creating SOS at station {}", stationId);
        sosService.triggerSOS(userId, stationId);
        return ResponseEntity.ok("SOS Alert Triggered");
    }
}
