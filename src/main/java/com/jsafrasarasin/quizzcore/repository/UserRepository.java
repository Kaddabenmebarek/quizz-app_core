/************************
*						*
*	Kadda Benmebarek	*
*						*
************************/
package com.jsafrasarasin.quizzcore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsafrasarasin.quizzcore.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    
//	@Query("SELECT u FROM Users u WHERE u.username = ?1")
//	public Optional<User> getUserByUsername(String username);
	
	public List<Users> findByUsername(String username);
}
