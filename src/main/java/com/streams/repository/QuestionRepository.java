package com.streams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.streams.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    // Custom method
    List<Question> findByDifficultyLevel(String difficultyLevel);
}