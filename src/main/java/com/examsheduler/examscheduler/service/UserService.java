package com.examsheduler.examscheduler.service;

import com.examsheduler.examscheduler.models.UserModel;
import com.examsheduler.examscheduler.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{
    private final UserRepository repository;
    public UserService(UserRepository repository){
        this.repository=repository;
    }
    @Override
    public List<UserModel> getAllUsers(){
        return repository.findAll();
    }
    @Override
    public UserModel getUserById(Long id){
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("no item with given id was found");
        }
        return repository.findById(id).orElse(null);
    }
}
