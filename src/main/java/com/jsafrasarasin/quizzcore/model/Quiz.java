/************************
*						*
*	Kadda Benmebarek	*
*						*
************************/
package com.jsafrasarasin.quizzcore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="quizzes")
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String quizName;

	@Column(nullable = false)
	private String technology;

//	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
//	private List<QuizQuestion> quizQuestions;
	@JsonIgnoreProperties("quiz") // Add this annotation
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
	private List<QuizQuestion> quizQuestions;


	public Quiz(Long id, String quizName, String technology, List<QuizQuestion> quizQuestions) {
		super();
		this.id = id;
		this.quizName = quizName;
		this.technology = technology;
		this.quizQuestions = quizQuestions;
	}
	
	public Quiz(String quizName, String technology, List<QuizQuestion> quizQuestions) {
		super();
		this.quizName = quizName;
		this.technology = technology;
		this.quizQuestions = quizQuestions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public List<QuizQuestion> getQuizQuestions() {
		return quizQuestions;
	}

	public void setQuizQuestions(List<QuizQuestion> quizQuestions) {
		this.quizQuestions = quizQuestions;
	}

	public Quiz() {
		super();
	}

}