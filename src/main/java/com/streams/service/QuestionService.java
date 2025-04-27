package com.streams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streams.entity.EasyQuestion;
import com.streams.entity.HardQuestion;
import com.streams.entity.MediumQuestion;
import com.streams.entity.Question;
import com.streams.repository.EasyQuestionRepository;
import com.streams.repository.HardQuestionRepository;
import com.streams.repository.MediumQuestionRepository;
import com.streams.repository.QuestionRepository;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private MediumQuestionRepository mediumQuestionRepository;
    @Autowired
    private EasyQuestionRepository easyQuestionRepository;

    @Autowired
    private HardQuestionRepository hardQuestionRepository;
    
    public List<EasyQuestion> getEasyQuestions() {
        return easyQuestionRepository.findByDifficultyLevel("Easy");
    }
    
    public List<Question> getRaviQuestions() {
        return questionRepository.findByDifficultyLevel("ravi");
    }
    
    public List<MediumQuestion> getMediumQuestions() {
        return mediumQuestionRepository.findByDifficultyLevel("Medium");
    }
    
    public List<HardQuestion> getHardQuestions() {
        return hardQuestionRepository.findByDifficultyLevel("Hard");
    }

    public Question getQuestionById(int id) {
        // Assuming you're using JPA or another ORM framework
        return questionRepository.findById(id).orElse(null); // Returns null if not found
    }
}