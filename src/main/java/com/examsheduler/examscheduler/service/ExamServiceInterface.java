package com.examsheduler.examscheduler.service;

import com.examsheduler.examscheduler.models.Exams;

import java.util.List;

public interface ExamServiceInterface {
    List<Exams> findAllExams();
    Exams getExamsById(Long id);
    List<Exams> getExamsByUnitName(String name);
    List<Exams> getExamByCourseName(String course);
    Exams createNewExam(Exams exam,Long id);
}
