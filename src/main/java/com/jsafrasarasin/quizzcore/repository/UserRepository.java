/************************
*						*
*	Kadda Benmebarek	*
*						*
************************/
package com.jsafrasarasin.quizzcore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsafrasarasin.quizzcore.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    
	@Query(value = "SELECT id FROM USERS WHERE username =  ?1", nativeQuery = true)
	public Long getUserIdByUsername(String username);
	
	public List<Users> findByUsername(String username);
}
