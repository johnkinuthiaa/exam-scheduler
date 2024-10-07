package com.examsheduler.examscheduler.controller;

import com.examsheduler.examscheduler.models.Exams;

import com.examsheduler.examscheduler.service.ExamServiceInterface;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Exams> getExamsById(@RequestParam Long id){
        return new ResponseEntity<>(service.getExamsById(id),HttpStatus.OK);
    }
    @GetMapping("/get/unit-name")
    public  ResponseEntity<List<Exams>>  getExamsByUnitName(@RequestParam String name){
        return new ResponseEntity<>(service.getExamsByUnitName(name),HttpStatus.OK);
    }
    @GetMapping("/get/course-name")
    public ResponseEntity<List<Exams>> getExamByCourseName(@RequestParam String course){
        return new ResponseEntity<>(service.getExamByCourseName(course),HttpStatus.OK);
    }
    @GetMapping("/get/building")
    public ResponseEntity<List<Exams>> getExamsByTheirVenue(@RequestParam String building){
        return new ResponseEntity<>(service.getExamsByTheirVenue(building),HttpStatus.OK);

    }
    @PostMapping("/create/new-exam")
    public ResponseEntity<Exams> createNewExam(@RequestBody Exams exam,@RequestParam Long id){
        return new ResponseEntity<>(service.createNewExam(exam,id),HttpStatus.OK);
    }
    @PutMapping("/update/exam")
    public ResponseEntity<Exams> updateExistingExam(@RequestBody Exams exam,@RequestParam Long id){
        return new ResponseEntity<>(service.updateExistingExam(exam,id),HttpStatus.OK);

    }
    @DeleteMapping("/delete/id")
    public void deleteExamById(@RequestParam Long id){
        service.deleteExamById(id);
    }
    @DeleteMapping("/delete/all")
    public void deleteAllExams(){
        service.deleteAllExams();
    }

}
