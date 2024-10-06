package com.examsheduler.examscheduler.service;

import com.examsheduler.examscheduler.models.HistoricExams;

import java.util.List;

public interface HistoricExamsServiceInterface {
    List<HistoricExams> getAllHistoricExams();
    List<HistoricExams> getHistoricExamByName(String name);
    HistoricExams createNewHistoricExam(HistoricExams exams,Long id);
    HistoricExams updateExistingExam(HistoricExams exams,Long id);
    void deleteExamById(Long id);
    void deleteAllExams();
}
