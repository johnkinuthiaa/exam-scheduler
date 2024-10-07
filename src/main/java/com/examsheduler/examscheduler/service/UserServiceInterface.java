package com.examsheduler.examscheduler.service;

import com.examsheduler.examscheduler.models.UserModel;

import java.util.List;

public interface UserServiceInterface {
    List<UserModel> getAllUsers();
    UserModel getUserById(Long id);
    UserModel createNewStudent(String username,String email,String phoneNumber,String password);
    List<UserModel> getUserByName(String name);
    List<UserModel> getUserByEmail(String email);
    void deleteUserById(Long id);
    void deleteAll();
}
