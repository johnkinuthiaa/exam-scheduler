package com.examsheduler.examscheduler.repository;

import com.examsheduler.examscheduler.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Long> {
    Optional<UserModel> findByUserName(String username);
}
