package com.game.CoolCool;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "FIRE-SERVICE")
public interface FireFeignClient {

    @GetMapping("/fire/allUsers")
    CoolModel[] getAllUsers();

    @PostMapping("/fire/create")
    CoolModel createUser(@RequestBody CoolModel request);

    @PutMapping("/fire/update/{id}")
    void updateUser(@PathVariable int id, @RequestBody CoolModel request);

    @DeleteMapping("/fire/delete/{id}")
    void deleteUser(@PathVariable int id);
}