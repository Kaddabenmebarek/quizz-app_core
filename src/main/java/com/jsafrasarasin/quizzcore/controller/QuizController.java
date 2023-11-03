/************************
*						*
*	Kadda Benmebarek	*
*						*
************************/
package com.jsafrasarasin.quizzcore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsafrasarasin.quizzcore.model.Questions;
import com.jsafrasarasin.quizzcore.model.Quiz;
import com.jsafrasarasin.quizzcore.model.QuizQuestion;
import com.jsafrasarasin.quizzcore.service.QuizService;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "http://localhost:3000")
public class QuizController {
	private final QuizService quizService;

	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}

//  public Quiz createQuiz(@RequestBody Quiz quiz) {
//  return quizService.createQuiz(quiz);
//}

	@PostMapping
	public Quiz createQuiz(@RequestBody Quiz quiz) {
		List<QuizQuestion> quizQuestions = quiz.getQuizQuestions();
		for (QuizQuestion quizQuestion : quizQuestions) {
			quizQuestion.setQuiz(quiz); // Set the quiz for each quiz question
		}
		return quizService.createQuiz(quiz);
	}

	@GetMapping("/{id}")
	public Quiz getQuizById(@PathVariable Long id) {
		return quizService.getQuizById(id);
	}

	@PutMapping("/{id}")
	public Quiz updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz) {
		return quizService.updateQuiz(id, quiz);
	}

	@DeleteMapping("/{id}")
	public void deleteQuiz(@PathVariable Long id) {
		quizService.deleteQuiz(id);
	}

	@GetMapping
	public List<Quiz> getAllQuizzes() {
		return quizService.getAllQuizes();
	}
	
	@GetMapping("/getQuizQuestById/{id}")
	public List<Questions> getQuizQuestById(@PathVariable Long id){
		System.out.println("Inside Get Quiz quest by Id");
		return quizService.getQuizQuestById(id);
	}
	
}
