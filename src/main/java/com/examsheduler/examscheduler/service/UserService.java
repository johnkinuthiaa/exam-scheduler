package com.examsheduler.examscheduler.service;

import com.examsheduler.examscheduler.models.UserModel;
import com.examsheduler.examscheduler.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    public UserModel createNewStudent(UserModel user,Long id){
        if(repository.findById(id).isPresent()){
            throw new RuntimeException("student already exists");
        }
        return repository.save(user);
    }
    @Override
    public List<UserModel> getUserByName(String name){
        return repository.findAll().stream()
                .filter(userModel -> userModel.getFirstName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public List<UserModel> getUserByEmail(String email){
        return repository.findAll().stream()
                .filter(userModel -> userModel.getEmail().toLowerCase().contains(email.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public void deleteUserById(Long id){
        repository.deleteById(id);
    }
    @Override
    public void deleteAll(){
        repository.deleteAll();
    }
}
