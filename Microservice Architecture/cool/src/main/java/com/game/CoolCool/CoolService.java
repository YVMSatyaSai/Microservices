//package com.game.CoolCool;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class CoolService {
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    @Value("${external.service.base-url}")
//    private String baseUrl;
//
//    public CoolModel[] getAllUsers() {
//        return restTemplate.getForObject(
//                baseUrl + "/allUsers",
//                CoolModel[].class
//        );
//    }
//
//    public CoolModel createUser(CoolModel request) {
//        return restTemplate.postForObject(
//                baseUrl + "/create",
//                request,
//                CoolModel.class
//        );
//    }
//
//    public CoolModel updateUser(int id, CoolModel request) {
//        restTemplate.put(baseUrl + "/update/" + id, request);
//        return request;
//    }
//
//    public void deleteUser(int id) {
//        restTemplate.delete(baseUrl + "/delete/" + id);
//    }
//}