package com.game.firefire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireService {

    @Autowired
    FireRepository fireRepository;

    public String greating() {
        return "Hello!...";
    }

    public FireModel    saveData(FireModel request) {
        FireModel fireModel = new FireModel();
        fireModel.update(request.getName());
       return fireRepository.save(fireModel);
    }


    public List<FireModel> getAllUser() {
        List<FireModel> data = fireRepository.findAll()
                .stream()
                .map(n -> new FireModel(n.getId(),n.getName()))
                .toList();
        return data;
    }

    public FireModel updateName(int id, FireModel request) {
        FireModel retrive = fireRepository.findById(id).orElse(null);
        retrive.setName(request.getName());
        return fireRepository.save(retrive);
    }

    public Void deletedata(int id) {
        fireRepository.deleteById(id);
        return null;
    }
}
