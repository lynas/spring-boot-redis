package com.lynas.demoredis.controller;

import com.lynas.demoredis.model.AppUser;
import com.lynas.demoredis.service.AppUserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("app_user")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping
    public AppUser save(@RequestBody AppUser appUser){
        return appUserService.save(appUser);
    }



    @GetMapping
    public Map<String, Object> getAll(){
        return appUserService.findAll();
    }

    @GetMapping("/{id}")
    public AppUser getOne(@PathVariable String id){
        return appUserService.findById(id);
    }


}
