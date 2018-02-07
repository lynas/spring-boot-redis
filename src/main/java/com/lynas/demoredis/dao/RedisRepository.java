package com.lynas.demoredis.dao;

import java.util.Map;

public interface RedisRepository {
    void save(String key, String hashKey, Object value);
    Map<String, Object> findAll(String  key);
    Object findById(String  key, String id);
}
