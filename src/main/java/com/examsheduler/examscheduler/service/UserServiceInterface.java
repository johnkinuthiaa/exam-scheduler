package com.examsheduler.examscheduler.service;

import com.examsheduler.examscheduler.models.UserModel;

import java.util.List;

public interface UserServiceInterface {
    List<UserModel> getAllUsers();
    UserModel getUserById(Long id);
    UserModel createNewStudent(UserModel user,Long id);
    List<UserModel> getUserByName(String name);
    List<UserModel> getUserByEmail(String email);
    void deleteUserById(Long id);
    void deleteAll();
}
