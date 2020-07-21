package com.jabogski.springsecurity.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.jabogski.springsecurity.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	User getUserByEmail(String email);



	void delete(User user);
	
}
