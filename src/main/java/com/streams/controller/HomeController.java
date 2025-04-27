package com.streams.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.streams.entity.EasyQuestion;
import com.streams.entity.HardQuestion;
import com.streams.entity.MediumQuestion;
import com.streams.entity.Question;
import com.streams.service.QuestionService;

@Controller
public class HomeController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	  @GetMapping("/easy")
	    public String getEasyQuestions(Model model) {
	        List<EasyQuestion> easyQuestions = questionService.getEasyQuestions();
	        model.addAttribute("questions", easyQuestions);
	        return "easy"; // easy.jsp
	    }
	  @GetMapping("/medium")
	  public String showmedium(Model model) {
	      List<MediumQuestion> mediumQuestions = questionService.getMediumQuestions();
	      model.addAttribute("questions", mediumQuestions);
	      return "medium";
	  }

	@GetMapping("/hard")
	public String showhard(Model model) {
		 List<HardQuestion> hardQuestions = questionService.getHardQuestions();
	        model.addAttribute("questions", hardQuestions);
		return "hard";
	}
	@GetMapping("/top85")
	public String showtop85(Model model) {
		 List<Question> raviQuestions = questionService.getRaviQuestions();
	        model.addAttribute("questions", raviQuestions);
	      
		return "top85";
	}
	
	@GetMapping("/showAns")
	public String showAnswer(@RequestParam("id") int id, Model model) {
	    // Fetch the question using the id
	    Question question = questionService.getQuestionById(id);
	    if (question != null) {
	        model.addAttribute("question", question);
	        return "showAns"; // View name will be resolved to /WEB-INF/views/showAnswer.jsp
	    } else {
	        model.addAttribute("error", "Question not found");
	        return "error"; // Handle error case
	    }
	}

}
