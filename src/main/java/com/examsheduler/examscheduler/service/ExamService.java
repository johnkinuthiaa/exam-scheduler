package com.examsheduler.examscheduler.service;

import com.examsheduler.examscheduler.models.Exams;
import com.examsheduler.examscheduler.repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamService implements ExamServiceInterface{
    private final ExamRepository repository;

    public ExamService(ExamRepository repository){
        this.repository=repository;
    }
    @Override
    public List<Exams> findAllExams(){
        return repository.findAll().stream().sorted()
                .collect(Collectors.toList());
    }
    @Override
    public Exams getExamsById(Long id){
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("exam not found");
        }
        return repository.findById(id).orElse(null);
    }
    @Override
    public List<Exams> getExamsByUnitName(String name){
        return repository.findAll().stream()
                .filter(exams ->exams.getUnitTitle().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public List<Exams> getExamByCourseName(String course){
        return repository.findAll().stream()
                .filter(exam ->exam.getCourseName().toLowerCase().contains(course.toLowerCase()))
                .collect(Collectors.toList());
    }
}
