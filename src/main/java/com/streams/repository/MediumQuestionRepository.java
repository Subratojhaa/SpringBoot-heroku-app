package com.streams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.streams.entity.MediumQuestion;
import com.streams.entity.Question;

public interface MediumQuestionRepository extends JpaRepository<MediumQuestion, Integer> {
	 // Custom method
	List<MediumQuestion> findByDifficultyLevel(String difficultyLevel);

}
