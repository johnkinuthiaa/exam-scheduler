package com.examsheduler.examscheduler.repository;

import com.examsheduler.examscheduler.models.HistoricExams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricExamRepository extends JpaRepository<HistoricExams,Long> {
}
