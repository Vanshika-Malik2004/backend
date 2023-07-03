package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepository extends JpaRepository<com.example.demo.entities.Questions, Long> {
    // Custom methods for question-related operations
}