package com.examsheduler.examscheduler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class HistoricExams {
    @Id
    private Long id;
    private String examType;
    private String examName;
    private LocalDate year;
    private LocalDate startTime;
    private LocalDate stopTime;
    private String examVenue;
    private String examRoom;

    public HistoricExams(){}
    public HistoricExams(Long id,String examType,String examName,LocalDate year,LocalDate startTime,LocalDate stopTime,String examVenue,String examRoom){
        this.id=id;
        this.examType=examType;
        this.examName=examName;
        this.year=year;
        this.startTime=startTime;
        this.stopTime=stopTime;
        this.examVenue=examVenue;
        this.examRoom=examRoom;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getId(){
        return id;
    }
    public void setExamType(String examType){
        this.examType=examType;
    }
    public String getExamType(){
        return examType;
    }
    public void setExamName(String examName){
        this.examName=examName;
    }
    public String getExamName(){
        return examName;
    }
    public void setYear(LocalDate year){
        this.year=year;
    }
    public LocalDate getYear(){
        return year;
    }
    public void setStartTime(LocalDate startTime){
        this.startTime=startTime;
    }
    public LocalDate getStartTime(){
        return startTime;
    }
    public void setStopTime(LocalDate stopTime){
        this.stopTime=stopTime;
    }
    public LocalDate getStopTime(){
        return stopTime;
    }
    public void setExamVenue(String examVenue){
        this.examVenue=examVenue;
    }
    public String getExamVenue(){
        return examVenue;
    }
    public void setExamRoom(String examRoom){
        this.examRoom=examRoom;
    }
    public String getExamRoom(){
        return examRoom;
    }
}
