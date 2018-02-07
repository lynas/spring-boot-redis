package com.lynas.demoredis.dao.impl;

import com.lynas.demoredis.dao.AppUserRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class AppUserRepositoryImpl implements AppUserRepository {

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
    public void save(String  key, String  hashKey, Object value) {
        hashOps.put(key, hashKey, value);
    }

    @Override
    public Map<String, Object> findAll(String  key) {
        return hashOps.entries(key);
    }

    public Object findById(String  key, String id) {
        return hashOps.get(key, id);
    }
}
