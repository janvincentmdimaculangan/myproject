package com.jabogski.springsecurity.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jabogski.springsecurity.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmailIgnoreCase(String username);
	void deleteById(long id);
	

}
