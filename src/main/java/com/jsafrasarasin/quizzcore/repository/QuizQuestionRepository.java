/************************
*						*
*	Kadda Benmebarek	*
*						*
************************/
package com.jsafrasarasin.quizzcore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsafrasarasin.quizzcore.model.Quiz;
import com.jsafrasarasin.quizzcore.model.QuizQuestion;

@Repository
public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long>{
	public List<QuizQuestion> findByQuiz(Quiz quiz);
}
