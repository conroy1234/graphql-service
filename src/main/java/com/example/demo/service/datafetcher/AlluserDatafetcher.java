package com.example.demo.service.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AlluserDatafetcher implements DataFetcher<List<User>>{
	
	@Autowired
	UserRepository  userRepository;
	
	@Override
	public List<User> get(DataFetchingEnvironment environment) {
		
		return userRepository.findAll();
	}

}
