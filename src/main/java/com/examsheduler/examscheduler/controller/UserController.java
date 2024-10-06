package com.examsheduler.examscheduler.controller;

import com.examsheduler.examscheduler.models.UserModel;
import com.examsheduler.examscheduler.service.UserServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserServiceInterface service;
    public UserController(UserServiceInterface service){
        this.service=service;
    }
    @GetMapping("/all")
    public ResponseEntity< List<UserModel>> getAllUsers(){
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

}
