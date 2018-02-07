package com.lynas.demoredis.service;

import com.lynas.demoredis.dao.RedisRepository;
import com.lynas.demoredis.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppUserService {
    private static final String KEY = "app_user";
    private final RedisRepository redisRepository;


    public AppUser save(AppUser appUser) {
        String randomId = UUID.randomUUID().toString();
        appUser.setId(randomId);
        redisRepository.save(KEY, randomId, appUser);
        return (AppUser) redisRepository.findById(KEY, randomId);
    }


    public Map<String, Object> findAll() {
        return redisRepository.findAll(KEY);
    }


    public AppUser findById(String id) {
        return (AppUser) redisRepository.findById(KEY, id);
    }



}
