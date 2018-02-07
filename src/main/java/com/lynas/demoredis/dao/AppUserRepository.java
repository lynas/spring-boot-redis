package com.lynas.demoredis.dao;

import com.lynas.demoredis.model.AppUser;

import java.util.Map;

public interface AppUserRepository {
    void save(String key, String hashKey, Object value);
    Map<String, Object> findAll(String  key);
    Object findById(String  key, String id);
}
