package com.game.firefire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fire")
public class FireController {

    @Autowired
    FireService fireService;

    @GetMapping("/users")
    public ResponseEntity<String> greating(){
        return ResponseEntity.ok().body(fireService.greating());
    }

    @PostMapping("/create")
    public ResponseEntity<FireModel> saveData(@RequestBody FireModel request){
        FireModel response = fireService.saveData(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<FireModel>> getAllUsers(){
        List<FireModel> response = fireService.getAllUser();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FireModel> updateName(@PathVariable int id, @RequestBody FireModel request){
        FireModel response = fireService.updateName(id,request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletedata(@PathVariable int id){
        Void response = fireService.deletedata(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}
