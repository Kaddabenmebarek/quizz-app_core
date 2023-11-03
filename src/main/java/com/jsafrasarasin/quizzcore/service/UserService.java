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

import com.jsafrasarasin.quizzcore.model.Users;
import com.jsafrasarasin.quizzcore.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Users createUser(Users user) {
		return userRepository.save(user);
	}

	public Users getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
	}
	
	public List<Users> findByUsername(String userName){
		return userRepository.findByUsername(userName);
	}

	public Users updateUser(Long id, Users updatedUser) {
		return userRepository.findById(id).map(user -> {
			user.setUsername(updatedUser.getUsername());
			user.setPassword(updatedUser.getPassword());
			user.setEmail(updatedUser.getEmail());
			user.setAdmin(updatedUser.isAdmin());
			return userRepository.save(user);
		}).orElseThrow(() -> new EntityNotFoundException("User not found"));
	}

	public void deleteUser(Long id) {
		if(!userRepository.existsById(id))
			throw new EntityNotFoundException("User not found");
		Users user = getUserById(id);
		userRepository.delete(user);
	}

	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<Users> findById(Long userId) {
		return userRepository.findById(userId);
	}

}
