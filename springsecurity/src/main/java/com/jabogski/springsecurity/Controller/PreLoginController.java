package com.jabogski.springsecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jabogski.springsecurity.Service.UserService;
import com.jabogski.springsecurity.domain.Response;
import com.jabogski.springsecurity.model.User;

@RestController
public class PreLoginController {
@Autowired private UserService userService;


@PostMapping(value="/registration")
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<Response> registration(@RequestBody User user){
	User dbUser = userService.save(user);
	if (dbUser != null) {
		return new ResponseEntity<Response>(new Response("User is saved successfull"), HttpStatus.OK);
	}
	return null;
}
}
