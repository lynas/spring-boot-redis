package com.lynas.demoredis.controller;

import com.lynas.demoredis.dao.AppUserRepository;
import com.lynas.demoredis.model.AppUser;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("app_user")
public class AppUserController {

    private final AppUserRepository appUserRepository;

    public AppUserController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @PostMapping
    public AppUser save(@RequestBody AppUser appUser){
        appUser.setId(UUID.randomUUID().toString());
        appUserRepository.save(appUser);
        return appUser;
    }



    @GetMapping
    public Map<String, AppUser> getAll(){
        return appUserRepository.findAll();
    }

    @GetMapping("/{id}")
    public AppUser getOne(@PathVariable String id){
        return appUserRepository.findById(id);
    }


}
