package com.examsheduler.examscheduler.service;

import com.examsheduler.examscheduler.models.UserModel;
import com.examsheduler.examscheduler.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInterface{
    private final UserRepository repository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

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
            throw new RuntimeException("no user with given id was found");
        }
        return repository.findById(id).orElse(null);
    }
    @Override
    public UserModel createNewStudent(String username,String email,String phoneNumber,String password){
        if(repository.findByUserName(username).isPresent()){
            throw new RuntimeException("username is taken");
        }
        UserModel userModel =new UserModel();
        userModel.setUserName(username);
        userModel.setEmail(email);
        userModel.setMobileNumber(phoneNumber);
        userModel.setPassword(encoder.encode(password));

        return repository.save(userModel);
    }
    public Collection<?extends GrantedAuthority> authorities(){
        return null;
    }
    @Override
    public List<UserModel> getUserByName(String name){
        return repository.findAll().stream()
                .filter(userModel -> userModel.getUserName().toLowerCase().contains(name.toLowerCase()))
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
