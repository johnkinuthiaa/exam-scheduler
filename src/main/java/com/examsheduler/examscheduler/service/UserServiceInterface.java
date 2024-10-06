package com.examsheduler.examscheduler.service;

import com.examsheduler.examscheduler.models.UserModel;

import java.util.List;

public interface UserServiceInterface {
    List<UserModel> getAllUsers();
    UserModel getUserById(Long id);
}
