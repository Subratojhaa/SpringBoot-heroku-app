package com.streams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.streams.entity.HardQuestion;

public interface HardQuestionRepository extends JpaRepository<HardQuestion, Integer> {
	 // Custom method
	List<HardQuestion> findByDifficultyLevel(String difficultyLevel);

}
