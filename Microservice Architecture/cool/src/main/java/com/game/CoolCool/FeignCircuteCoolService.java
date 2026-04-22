package com.game.CoolCool;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class FeignCircuteCoolService {

    @Autowired
    FireFeignClient fireFeignClient;

    @Retryable(value = Exception.class, maxAttempts = 3)
    @CircuitBreaker(name = "fireService", fallbackMethod = "fallbackGetAll")
    public CoolModel[] getAllUsers() {
        return fireFeignClient.getAllUsers();
    }

    @Retryable(value = Exception.class, maxAttempts = 3)
    @CircuitBreaker(name = "fireService", fallbackMethod = "fallbackCreate")
    public CoolModel createUser(CoolModel request) {
        return fireFeignClient.createUser(request);
    }

    @Retryable(value = Exception.class, maxAttempts = 3)
    @CircuitBreaker(name = "fireService", fallbackMethod = "fallbackUpdate")
    public CoolModel updateUser(int id, CoolModel request) {
        fireFeignClient.updateUser(id, request);
        return request;
    }

    @Retryable(value = Exception.class, maxAttempts = 3)
    @CircuitBreaker(name = "fireService", fallbackMethod = "fallbackDelete")
    public void deleteUser(int id) {
        fireFeignClient.deleteUser(id);
    }

    // 🔥 Fallback methods

    public CoolModel[] fallbackGetAll(Exception ex) {
        System.out.println("Fallback: getAllUsers failed");

        CoolModel fallback = new CoolModel();
        fallback.setId(0);
        fallback.setName("Fallback Data");

        return new CoolModel[]{fallback};
    }

    public CoolModel fallbackCreate(CoolModel request, Exception ex) {
        System.out.println("Fallback: createUser failed");
        return new CoolModel(0, "Create Failed - Fallback");
    }

    public CoolModel fallbackUpdate(int id, CoolModel request, Exception ex) {
        System.out.println("Fallback: updateUser failed");
        return new CoolModel(id, "Update Failed - Fallback");
    }

    public void fallbackDelete(int id, Exception ex) {
        System.out.println("Fallback: deleteUser failed");
    }
}