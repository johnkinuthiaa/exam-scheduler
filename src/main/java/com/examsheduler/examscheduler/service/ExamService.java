package com.examsheduler.examscheduler.service;

import com.examsheduler.examscheduler.models.Exams;
import com.examsheduler.examscheduler.repository.ExamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamService implements ExamServiceInterface{
    private static final Logger log = LoggerFactory.getLogger(ExamService.class);
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

    @Override
    public Exams createNewExam(Exams exam, Long id) {
        if(repository.findById(id).isPresent()){
            log.info("cannot create exam since it already exists");
            throw new RuntimeException();
        }
        return repository.save(exam);
    }

    @Override
    public Exams updateExistingExam(Exams exam, Long id) {
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("exam does not exist");
        }
        else {
            repository.deleteById(id);
        }
        return repository.save(exam);
    }
    @Override
    public void deleteAllExams(){
        repository.deleteAll();
    }
    @Override
    public void deleteExamById(Long id) throws RuntimeException{
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }else{
            throw new RuntimeException("EXAM NOT FOUND");
        }
    }
    @Override
    public List<Exams> getExamsByTheirVenue(String building){
        return repository.findAll().stream()
                .filter(exams ->exams.getBuilding().toLowerCase().contains(building.toLowerCase()))
                .collect(Collectors.toList());
    }
}
