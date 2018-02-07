package com.lynas.demoredis.service;

import com.lynas.demoredis.dao.AppUserRepository;
import com.lynas.demoredis.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppUserService {
    private static final String KEY = "app_user";
    private final AppUserRepository appUserRepository;


    public AppUser save(AppUser appUser) {
        String randomId = UUID.randomUUID().toString();
        appUser.setId(randomId);
        appUserRepository.save(KEY, randomId, appUser);
        return (AppUser) appUserRepository.findById(KEY, randomId);
    }


    public Map<String, Object> findAll() {
        return appUserRepository.findAll(KEY);
    }


    public AppUser findById(String id) {
        return (AppUser) appUserRepository.findById(KEY, id);
    }



}
