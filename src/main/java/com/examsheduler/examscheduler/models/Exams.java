package com.examsheduler.examscheduler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity

public class Exams {
    @Id
    private Long id;
    private String courseName;
    private String unitTitle;
    private LocalDate examPaperDate;
    private LocalDate paperStartTime;
    private LocalDate paperEndingTime;
    private String building;
    private String examRoom;

    public Exams(){}
    public Exams(Long id,
                 String courseName,
                 String unitTitle,
                 LocalDate examPaperDate,
                 LocalDate paperStartTime,
                 LocalDate paperEndingTime,
                 String building,
                 String examRoom
    ){
        this.id=id;
        this.courseName=courseName;
        this.unitTitle=unitTitle;
        this.examPaperDate=examPaperDate;
        this.paperStartTime=paperStartTime;
        this.paperEndingTime =paperEndingTime;
        this.building=building;
        this.examRoom=examRoom;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getId(){
        return id;
    }
    public void setCourseName(String courseName){
        this.courseName=courseName;
    }
    public String getCourseName(){
        return courseName;
    }
    public void setUnitTitle(String unitTitle){
        this.unitTitle=unitTitle;
    }
    public String getUnitTitle(){
        return unitTitle;
    }
    public void setExamPaperDate(LocalDate examPaperDate){
        this.examPaperDate=examPaperDate;
    }
    public LocalDate getExamPaperDate(){
        return examPaperDate;
    }
    public void setPaperStartTime(LocalDate paperStartTime){
        this.paperStartTime=paperStartTime;
    }
    public LocalDate getPaperStartTime(){
        return paperStartTime;
    }
    public void setPaperEndingTime(LocalDate paperEndingTime){
        this.paperEndingTime=paperEndingTime;
    }
    public LocalDate getPaperEndingTime(){
        return paperEndingTime;
    }
    public void setBuilding(String building){
        this.building=building;
    }
    public String getBuilding(){
        return building;
    }
    public void setExamRoom(String examRoom){
        this.examRoom=examRoom;
    }
    public String getExamRoom(){
        return examRoom;
    }
}
