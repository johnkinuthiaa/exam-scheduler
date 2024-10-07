package com.examsheduler.examscheduler.repository;

import com.examsheduler.examscheduler.models.Exams;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exams,Long> {
    List<Exams> findExamById(Long id);
}
