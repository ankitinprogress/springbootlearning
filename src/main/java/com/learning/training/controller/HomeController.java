package com.learning.training.controller;

import com.learning.training.enitity.Employee;
import com.learning.training.facade.TrainingDataOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Value("${user.name}")
    private String name;

    @Value("${user.role}")
    private String role;

    TrainingDataOperation trainingDataOperation;

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    public HomeController(TrainingDataOperation trainingDataOperation) {
        this.trainingDataOperation = trainingDataOperation;
    }


    @GetMapping("/home")
    public String home() {
        return String.format("Hello %s! you are %s", name, role);
    }

    @PostMapping("/addUser/{id}/{name}/{surname}/{email}/{phone}")
    public String addUser(@PathVariable("id") String id,
                          @PathVariable("name") String name,
                          @PathVariable("surname") String surname,
                          @PathVariable("email") String email,
                          @PathVariable("phone") String phone) {
        logger.info("addUser");
        return trainingDataOperation.addUser(new Employee(name, surname, email, phone));
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {
        logger.info("deleteUser");
//        trainingDataOperation.deleteUser(Integer.parseInt(userId));
        return "User deleted";
    }
}
