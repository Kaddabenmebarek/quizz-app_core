/************************
*						*
*	Kadda Benmebarek	*
*						*
************************/
package com.jsafrasarasin.quizzcore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsafrasarasin.quizzcore.model.Questions;
import com.jsafrasarasin.quizzcore.model.Quiz;
import com.jsafrasarasin.quizzcore.model.QuizQuestion;
import com.jsafrasarasin.quizzcore.repository.QuestionRepository;
import com.jsafrasarasin.quizzcore.repository.QuizQuestionRepository;
import com.jsafrasarasin.quizzcore.repository.QuizRepository;

@Service
public class QuizService {
	@Autowired
	private final QuizRepository quizRepository;
	
	@Autowired
	private QuizQuestionRepository quizQuestionRepository;
	
	@Autowired
	private QuestionRepository questionsRepository;
	
	public QuizService(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}

	public Quiz createQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	public Quiz getQuizById(Long id) {
		return quizRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quizz not found"));
	}

	public Quiz updateQuiz(Long id, Quiz updatedQuiz) {
		return quizRepository.findById(id).map(quiz -> {
			quiz.setQuizName(updatedQuiz.getQuizName());
			quiz.setTechnology(updatedQuiz.getTechnology());
			return quizRepository.save(quiz);
		}).orElseThrow(() -> new EntityNotFoundException("Quiz not found"));
	}

	public void deleteQuiz(Long id) {
		Quiz quiz = getQuizById(id);
		quizRepository.delete(quiz);
	}

	public List<Quiz> getAllQuizes() {
		return quizRepository.findAll();
	}
	
	public List<Questions> getQuizQuestById(Long id){
		System.out.println("Id"+id);
	    List<QuizQuestion> quizQuesList =  quizQuestionRepository.findByQuiz(getQuizById(id));
	    List<Questions> questionList = new ArrayList<>();
	    for(QuizQuestion quizQues: quizQuesList) {
	        Optional<Questions> optionalQuestions = questionsRepository.findById(quizQues.getQuestion().getId());
	        optionalQuestions.ifPresent(questionList::add);
	    }
	    
	    questionList.forEach(q->System.out.println(q.getQuestionText()));
	    return questionList;
	}
}