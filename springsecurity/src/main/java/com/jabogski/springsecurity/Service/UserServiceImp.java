package com.jabogski.springsecurity.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jabogski.springsecurity.model.User;
import com.jabogski.springsecurity.repository.UserRepository;
import com.jabogski.springsecurity.util.PasswordUtil;

@Service
@Transactional
public class UserServiceImp implements UserService {
	
	
	@Autowired UserRepository userRepository;

	@Override
	public User save(User user) {
	String password = PasswordUtil.getPasswordHash(user.getPassword());
	user.setPassword(password);
	user.setCreateDate(new Date());
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		
		return userRepository.findByEmailIgnoreCase(email);
	}

	
	public void delete(User user) {
		
		
	}

	
	}

	
	


