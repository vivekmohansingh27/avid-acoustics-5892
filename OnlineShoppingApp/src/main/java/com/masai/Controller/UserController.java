package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Service.UserService;
import com.masai.model.User;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/login")
	public ResponseEntity<String> logInCustomer(@RequestBody User user) {

		String result = service.loginToAccount(user);

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}
	@PostMapping("/logout")
	public ResponseEntity<String> logOutCustomer(@RequestParam(required = false) String key) {

		String result = service.logOutFromAccount(key);

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}


}