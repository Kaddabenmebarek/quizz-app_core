/************************
*						*
*	Kadda Benmebarek	*
*						*
************************/
package com.jsafrasarasin.quizzcore.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsafrasarasin.quizzcore.model.UserAnswers;
import com.jsafrasarasin.quizzcore.repository.UserAnswerRepository;

@Service
public class UserAnswerService {

	@Autowired
	private UserAnswerRepository userAnswerRepository;

	public UserAnswers createUserAnswer(UserAnswers userAnswer) {
		return userAnswerRepository.save(userAnswer);
	}

	public UserAnswers getUserAnswerById(Long id) {
		return userAnswerRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("User Answer not found"));
	}

	public UserAnswers updateUserAnswer(Long id, UserAnswers updatedUserAnswer) {
		return userAnswerRepository.findById(id).map(userAnswer -> {
			userAnswer.setUsers(updatedUserAnswer.getUsers());
			userAnswer.setQuestions(updatedUserAnswer.getQuestions());
			userAnswer.setSelectedOption(updatedUserAnswer.getSelectedOption());
			return userAnswerRepository.save(userAnswer);
		}).orElseThrow(() -> new EntityNotFoundException("User Answer not found"));
	}

	public void deleteUserAnswer(Long id) {
		UserAnswers userAnswer = getUserAnswerById(id);
		userAnswerRepository.delete(userAnswer);
	}

	public List<UserAnswers> getAllUserAnswers() {
		return userAnswerRepository.findAll();
	}

	public UserAnswers save(UserAnswers userAnswer) {
		return userAnswerRepository.save(userAnswer);
	}

}
