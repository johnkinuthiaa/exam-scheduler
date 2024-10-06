package com.examsheduler.examscheduler.repository;

import com.examsheduler.examscheduler.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Long> {
}
