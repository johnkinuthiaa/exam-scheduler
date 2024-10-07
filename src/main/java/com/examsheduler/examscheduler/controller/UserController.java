package com.examsheduler.examscheduler.controller;

import com.examsheduler.examscheduler.models.UserModel;
import com.examsheduler.examscheduler.service.UserServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserServiceInterface service;
    public UserController(UserServiceInterface service){
        this.service=service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/get/id")
    public ResponseEntity<UserModel> getUserById(@RequestParam Long id){
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }
    @GetMapping("/get/name")
    public ResponseEntity<List<UserModel>> getUserByName(@RequestParam String name){
        return new ResponseEntity<>(service.getUserByName(name),HttpStatus.OK);
    }
    @GetMapping("/get/email")
    public ResponseEntity<List<UserModel>> getUserByEmail(@RequestParam String email){
        return new ResponseEntity<>(service.getUserByEmail(email),HttpStatus.OK);
    }
    @PostMapping("/create/new")
    public ResponseEntity<UserModel> createNewStudent(@RequestParam String username,@RequestParam String email,@RequestParam String phoneNumber,@RequestParam String password){
        return new ResponseEntity<>(service.createNewStudent(username,email,phoneNumber,password),HttpStatus.OK);
    }
    @DeleteMapping("/delete/id")
    public void deleteUserById(@RequestParam Long id){
        service.deleteUserById(id);
    }
    @DeleteMapping("/delete/all")
    public void deleteAll(){
        service.deleteAll();
    }


}
