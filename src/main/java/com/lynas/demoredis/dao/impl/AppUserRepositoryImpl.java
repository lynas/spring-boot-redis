package com.lynas.demoredis.dao.impl;

import com.lynas.demoredis.dao.AppUserRepository;
import com.lynas.demoredis.model.AppUser;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class AppUserRepositoryImpl implements AppUserRepository {

    private static final String KEY = "APP_USER";

    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOps;

    public AppUserRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    @PostConstruct
    private void init() {
        hashOps = redisTemplate.opsForHash();
    }


    @Override
    public void save(AppUser user) {
        hashOps.put(KEY, user.getId(), user);
    }

    @Override
    public Map<String, AppUser> findAll() {
        return hashOps.entries(KEY);
    }

    @Override
    public AppUser findById(String id) {
        return (AppUser) hashOps.get(KEY, id);
    }
}
