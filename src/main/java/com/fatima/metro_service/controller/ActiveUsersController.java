package com.fatima.metro_service.controller;

import com.fatima.metro_service.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/activeusers")
@RequiredArgsConstructor
public class ActiveUsersController {
    private final RedisService redisService;

    @GetMapping()
    public ResponseEntity<Set<Object>> getActiveUsers() {
        return ResponseEntity.ok(redisService.getActiveUsers());
    }
}