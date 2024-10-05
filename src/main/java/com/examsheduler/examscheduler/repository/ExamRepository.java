package com.examsheduler.examscheduler.repository;

import com.examsheduler.examscheduler.models.Exams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exams,Long> {
}
