package com.fatima.metro_service.service;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SosService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void triggerSOS(Long userId, String stationName) {
        Map<String, Object> sosData = new HashMap<>();
        sosData.put("userId", userId);
        sosData.put("station", stationName);
        sosData.put("message", "Emergency at " + stationName + " station");

        kafkaTemplate.send("sos_alert", sosData.toString());
    }
}

