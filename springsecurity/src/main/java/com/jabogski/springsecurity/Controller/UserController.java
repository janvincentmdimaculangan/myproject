package com.jabogski.springsecurity.Controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.jabogski.springsecurity.Service.UserService;
import com.jabogski.springsecurity.model.User;
import com.jabogski.springsecurity.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value="/users")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<User>>getAllusers(){
		List<User> users = userService.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getuser")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<User> getUser(Principal principal){
		User users = userService.getUserByEmail(principal.getName());
		return new ResponseEntity<User>(users, HttpStatus.OK);
		
	}
	@DeleteMapping(path = "/userdelete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public  Map<String, Boolean>  deleteUser(@PathVariable(value = "id") long id) {
		userRepository.deleteById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
		
	}

}
