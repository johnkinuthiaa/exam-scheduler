package com.examsheduler.examscheduler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserModel {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String password;

    public UserModel(){}
    public UserModel(Long id,String firstName,String lastName,String email,String mobileNumber,String password){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.mobileNumber=mobileNumber;
        this.password=password;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(){
        this.lastName=lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setMobileNumber(String mobileNumber){
        this.mobileNumber=mobileNumber;
    }
    public String getMobileNumber(){
        return mobileNumber;
    }
    public void setPassword(){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
}
