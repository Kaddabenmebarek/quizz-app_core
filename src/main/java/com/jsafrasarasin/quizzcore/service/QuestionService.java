/************************
*						*
*	Kadda Benmebarek	*
*						*
************************/
package com.jsafrasarasin.quizzcore.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsafrasarasin.quizzcore.model.Questions;
import com.jsafrasarasin.quizzcore.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionsRepository;

	public Questions createQuestion(Questions question) {
		return questionsRepository.save(question);
	}

	public Questions getQuestionById(Long id) {
		return questionsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Question not found"));
	}

	public Questions updateQuestion(Long id, Questions updatedQuestion) {
		return questionsRepository.findById(id).map(question -> {
			question.setQuestionText(updatedQuestion.getQuestionText());
			question.setOption1(updatedQuestion.getOption1());
			question.setOption2(updatedQuestion.getOption2());
			question.setOption3(updatedQuestion.getOption3());
			question.setOption4(updatedQuestion.getOption4());
			question.setCorrectOption(updatedQuestion.getCorrectOption());
			question.setTechnology(updatedQuestion.getTechnology());
			return questionsRepository.save(question);
		}).orElseThrow(() -> new EntityNotFoundException("Question not found"));
	}

	public void deleteQuestion(Long id) {
		Questions question = getQuestionById(id);
		questionsRepository.delete(question);
	}

	public List<Questions> getAllQuestions() {
		return questionsRepository.findAll();
	}

	public Optional<Questions> findById(Long questionId) {
		return questionsRepository.findById(questionId);
	}

}
