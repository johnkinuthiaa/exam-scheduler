package com.examsheduler.examscheduler.service;

import com.examsheduler.examscheduler.models.HistoricExams;
import com.examsheduler.examscheduler.repository.HistoricExamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricExamService implements HistoricExamsServiceInterface{
    private static final Logger log = LoggerFactory.getLogger(HistoricExamService.class);
    private final HistoricExamRepository repository;

    public HistoricExamService(HistoricExamRepository repository){
        this.repository=repository;
    }
    @Override
    public List<HistoricExams> getAllHistoricExams(){
        if(repository.findAll().isEmpty()){
            throw new RuntimeException("exams list is empty");
        }
        return repository.findAll();
    }
    @Override
    public List<HistoricExams> getHistoricExamByName(String name){
        return repository.findAll().stream()
                .filter(historicExams ->historicExams.getExamName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public HistoricExams createNewHistoricExam(HistoricExams exams,Long id){
        if(repository.findById(id).isPresent()){
            throw new RuntimeException("exam already exists");
        }
        return repository.save(exams);
    }
    @Override
    public HistoricExams updateExistingExam(HistoricExams exams,Long id){
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("the exam was not found");
        }
        else {
            repository.deleteById(id);
        }
        return repository.save(exams);
    }
    @Override
    public void deleteExamById(Long id){
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }
        else{

            throw new RuntimeException("exam not found");
        }
    }
    @Override
    public void deleteAllExams(){
        if(repository.findAll().isEmpty()){
            throw new RuntimeException("list is already empty");
        }
        else {
            repository.deleteAll();
        }
    }

}
