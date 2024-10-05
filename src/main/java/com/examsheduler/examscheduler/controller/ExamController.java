package com.examsheduler.examscheduler.controller;

import com.examsheduler.examscheduler.models.Exams;
import com.examsheduler.examscheduler.service.ExamServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exam-scheduler")
public class ExamController {
    private final ExamServiceInterface service;

    public ExamController(ExamServiceInterface service){
        this.service=service;
    }
    @GetMapping("/get/all-exams")
    public ResponseEntity<List<Exams>> findAllExams(){
        return new ResponseEntity<>(service.findAllExams(), HttpStatus.OK);
    }
    @GetMapping("/get/id")
    public  ResponseEntity<Exams> getExamsById(@RequestParam Long id){
        return new ResponseEntity<>(service.getExamsById(id),HttpStatus.OK);
    }
    @GetMapping("/get/unit-name")
    public  ResponseEntity<List<Exams>>  getExamsByUnitName(@RequestParam String name){
        return new ResponseEntity<>(service.getExamsByUnitName(name),HttpStatus.OK);
    }
    @GetMapping("/get/course-name")
    public ResponseEntity<List<Exams>> getExamByCourseName(@RequestParam String course){

    }
}
