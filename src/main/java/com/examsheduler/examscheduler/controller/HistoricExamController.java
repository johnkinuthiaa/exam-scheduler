package com.examsheduler.examscheduler.controller;

import com.examsheduler.examscheduler.models.HistoricExams;
import com.examsheduler.examscheduler.service.HistoricExamsServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/historic-exams")
public class HistoricExamController {
    private final HistoricExamsServiceInterface service;

    public HistoricExamController(HistoricExamsServiceInterface service){
        this.service=service;
    }
    @GetMapping("/get/all")
    public ResponseEntity<List<HistoricExams>> getAllHistoricExams(){
        return new ResponseEntity<>(service.getAllHistoricExams(), HttpStatus.OK);
    }
    @GetMapping("/get/name")
    public ResponseEntity<List<HistoricExams>> getHistoricExamByName(@RequestParam String name){
        return new ResponseEntity<>(service.getHistoricExamByName(name),HttpStatus.OK);
    }
    @PostMapping("/create/new-exam")
    public ResponseEntity<HistoricExams> createNewHistoricExam(@RequestBody HistoricExams exams,@RequestParam Long id){
        return new ResponseEntity<>(service.createNewHistoricExam(exams,id),HttpStatus.OK);
    }
    @PutMapping("/update/existing-exam")
    public ResponseEntity<HistoricExams> updateExistingExam(@RequestBody HistoricExams exams,@RequestParam Long id){
        return new ResponseEntity<>(service.updateExistingExam(exams,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/by-id")
    public void deleteExamById(@RequestParam Long id){
        service.deleteExamById(id);
    }
    @DeleteMapping
    public void deleteAllExams(){
        service.deleteAllExams();
    }
}
