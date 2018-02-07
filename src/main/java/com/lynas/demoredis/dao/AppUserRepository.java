package com.lynas.demoredis.dao;

import com.lynas.demoredis.model.AppUser;

import java.util.Map;

public interface AppUserRepository {
    void save(AppUser user);
    Map<String, AppUser> findAll();
    AppUser findById(String id);
}
