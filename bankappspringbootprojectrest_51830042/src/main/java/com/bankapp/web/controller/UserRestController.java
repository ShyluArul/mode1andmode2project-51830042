package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.exceptionhandler.UserNotFoundEx;
import com.bankapp.model.entities.User;
import com.bankapp.model.service.UserService;

@RestController
@RequestMapping(path = "/api")
public class UserRestController {

	private UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUser() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getAnUser(@PathVariable(name = "id") Long id) {
		User user = userService.findUserById(id).orElseThrow(UserNotFoundEx::new);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteAnUser(@PathVariable(name = "id") Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping(path = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateAnUser(@PathVariable(name = "id") Long id, @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(id, user), HttpStatus.OK);
	}

	@PostMapping(path = "user")
	public ResponseEntity<User> addAnUser(/* @Valid */ @RequestBody User user) {
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
	}

}
