package com.examsheduler.examscheduler.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class UserModel implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String mobileNumber;
    private String password;
    private String role;

    @OneToMany(mappedBy = "UserModel")
    private List<Exams> exams;


    public UserModel(){}
    public UserModel(String userName,String email,String mobileNumber,String password,List<Exams> exams,String role){
        this.userName=userName;
        this.email=email;
        this.mobileNumber=mobileNumber;
        this.password=password;
        this.exams=exams;
        this.role =role;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getId(){
        return id;
    }
    public void setExams(List<Exams> exams){
        this.exams=exams;
    }
    public List<Exams> getExams(){
        return exams;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getUserName(){
        return userName;
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
    public void setPassword(String encode){
        this.password=password;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
}
