/************************
*						*
*	Kadda Benmebarek	*
*						*
************************/
package com.jsafrasarasin.quizzcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsafrasarasin.quizzcore.model.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Long> {

}

