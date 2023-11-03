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

import com.jsafrasarasin.quizzcore.dto.UserAnswersDto;
import com.jsafrasarasin.quizzcore.model.Questions;
import com.jsafrasarasin.quizzcore.model.Users;
import com.jsafrasarasin.quizzcore.model.UserAnswers;
import com.jsafrasarasin.quizzcore.service.QuestionService;
import com.jsafrasarasin.quizzcore.service.UserAnswerService;
import com.jsafrasarasin.quizzcore.service.UserService;

@RestController
@RequestMapping("/api/user-answers")
@CrossOrigin(origins = "http://localhost:3000")
public class UserAnswerController {

	@Autowired
	private UserAnswerService userAnswerService;

	@Autowired
	private UserService userService;

	@Autowired
	private QuestionService questionService;

	public UserAnswerController(UserAnswerService userAnswerService) {
		this.userAnswerService = userAnswerService;
	}

//    @PostMapping
//    public UserAnswers createUserAnswer(@RequestBody UserAnswers userAnswer) {
//        return userAnswerService.createUserAnswer(userAnswer);
//    }

	@PostMapping
	public UserAnswers createUserAnswer(@RequestBody UserAnswersDto userAnswerDto) {
		Users user = userService.findById(userAnswerDto.getUserId())
				.orElseThrow(() -> new IllegalArgumentException("User not found"));

		Questions question = questionService.findById(userAnswerDto.getQuestionId())
				.orElseThrow(() -> new IllegalArgumentException("Question not found"));

		UserAnswers userAnswer = new UserAnswers();
		userAnswer.setUsers(user);
		userAnswer.setQuestions(question);
		userAnswer.setSelectedOption(userAnswerDto.getSelectedOption());

		return userAnswerService.save(userAnswer);
	}

	@GetMapping("/{id}")
	public UserAnswers getUserAnswerById(@PathVariable Long id) {
		return userAnswerService.getUserAnswerById(id);
	}

	@PutMapping("/{id}")
	public UserAnswers updateUserAnswer(@PathVariable Long id, @RequestBody UserAnswers userAnswer) {
		return userAnswerService.updateUserAnswer(id, userAnswer);
	}

	@DeleteMapping("/{id}")
	public void deleteUserAnswer(@PathVariable Long id) {
		userAnswerService.deleteUserAnswer(id);
	}

	@GetMapping
	public List<UserAnswers> getAllUserAnswers() {
		return userAnswerService.getAllUserAnswers();
	}
}
