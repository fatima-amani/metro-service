package com.fatima.metro_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisService {
    private final RedisTemplate<String, Object> redisTemplate;
    private static final String ACTIVE_USERS_KEY = "active_users";

    public void addActiveUser(String userId) {
        redisTemplate.opsForSet().add(ACTIVE_USERS_KEY, userId);
        redisTemplate.expire(ACTIVE_USERS_KEY, 2, TimeUnit.HOURS); // Auto-expire after 2 hours
    }

    public void removeActiveUser(String userId) {
        redisTemplate.opsForSet().remove(ACTIVE_USERS_KEY, userId);
    }

    public Set<Object> getActiveUsers() {
        return redisTemplate.opsForSet().members(ACTIVE_USERS_KEY);
    }
}

