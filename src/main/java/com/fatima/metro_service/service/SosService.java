package com.fatima.metro_service.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SosService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void triggerSOS(Long userId, Long stationId) {
        Map<String, Object> sosData = new HashMap<>();
        sosData.put("userId", userId);
        sosData.put("stationId", stationId);
        sosData.put("message", "Emergency !!");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonMessage = objectMapper.writeValueAsString(sosData);
            System.out.println("Sending JSON Message: " + jsonMessage);
            kafkaTemplate.send("sos_alert", jsonMessage);
        } catch (Exception e) {
            System.err.println("Error sending SOS alert: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

