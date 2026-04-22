package com.game.CoolCool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/cool")
    public class CoolController {

        @Autowired
//        CoolService coolService;
//        FeignCoolService coolService;
        FeignCircuteCoolService coolService;

        @Autowired
        KafkaProducerService producer;

        public void createUser(CoolModel request) {

            producer.send(request.getName());

        }

        @GetMapping("/all")
        public CoolModel[] getAll() {
            return coolService.getAllUsers();
        }

        @PostMapping("/create")
        public CoolModel create(@RequestBody CoolModel request) {
            return coolService.createUser(request);
        }

        @PutMapping("/update/{id}")
        public CoolModel update(@PathVariable int id, @RequestBody CoolModel request) {
            return coolService.updateUser(id, request);
        }

        @DeleteMapping("/delete/{id}")
        public String delete(@PathVariable int id) {
            coolService.deleteUser(id);
            return "Deleted Successfully";
        }
    }
