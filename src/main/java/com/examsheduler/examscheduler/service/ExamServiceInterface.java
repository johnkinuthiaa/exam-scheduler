package com.examsheduler.examscheduler.service;

import com.examsheduler.examscheduler.models.Exams;

import java.util.List;

public interface ExamServiceInterface {
    List<Exams> findAllExams();
    Exams getExamsById(Long id);
    List<Exams> getExamsByUnitName(String name);
    List<Exams> getExamByCourseName(String course);
    List<Exams> getExamsByTheirVenue(String building);
    Exams createNewExam(Exams exam,Long id);
    Exams updateExistingExam(Exams exam,Long id);
    void deleteAllExams();
    void deleteExamById(Long id);
}
