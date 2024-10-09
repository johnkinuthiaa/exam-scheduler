package com.examsheduler.examscheduler.dto;
import com.examsheduler.examscheduler.models.Exams;
import com.examsheduler.examscheduler.models.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqRes {
    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expiryTime;
    private String userName;
    private String email;
    private String mobileNumber;
    private String role;
    private String password;
    private List<Exams> exams;
    private UserModel users;


}
