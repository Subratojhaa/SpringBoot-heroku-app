package com.streams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.streams.entity.EasyQuestion;

public interface EasyQuestionRepository extends JpaRepository<EasyQuestion, Integer> {
	 // Custom method
	List<EasyQuestion> findByDifficultyLevel(String difficultyLevel);

}
