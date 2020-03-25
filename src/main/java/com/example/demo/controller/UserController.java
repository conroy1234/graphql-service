package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user-result")
	public ResponseEntity<Object> getAllUsers(@RequestBody String query) {
		
		ExecutionResult result = userService.createCraphql().execute(query);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}
}
