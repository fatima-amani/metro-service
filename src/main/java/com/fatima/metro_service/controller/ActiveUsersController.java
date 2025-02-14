package com.fatima.metro_service.controller;

import com.fatima.metro_service.service.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/activeusers")
@RequiredArgsConstructor
@Slf4j
public class ActiveUsersController {

    private final RedisService redisService;

    @GetMapping
    @Cacheable(value = "activeUsersCache")
    public ResponseEntity<Set<Object>> getActiveUsers() {
        log.info("Fetching active users ");

        try {
            Set<Object> activeUsers = redisService.getActiveUsers();
            log.info("Successfully retrieved {} active users.", activeUsers.size());
            return ResponseEntity.ok(activeUsers);
        } catch (Exception e) {
            log.error("Error fetching active users: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
