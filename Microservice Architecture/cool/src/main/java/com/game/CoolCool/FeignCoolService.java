//package com.game.CoolCool;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class FeignCoolService {
//
//    @Autowired
//    FireFeignClient fireFeignClient;
//
//    public CoolModel[] getAllUsers() {
//        return fireFeignClient.getAllUsers();
//    }
//
//    public CoolModel createUser(CoolModel request) {
//        return fireFeignClient.createUser(request);
//    }
//
//    public CoolModel updateUser(int id, CoolModel request) {
//        fireFeignClient.updateUser(id, request);
//        return request;
//    }
//
//    public void deleteUser(int id) {
//        fireFeignClient.deleteUser(id);
//    }
//}