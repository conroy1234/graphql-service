package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BookService;
import com.example.demo.service.UserService;

import graphql.ExecutionResult;

@RequestMapping("/api")
@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	
	
	@PostMapping("/all")
	public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
		
		ExecutionResult result = bookService.getGraphql().execute(query);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}
	

	

}
