package com.example.demo.service.datafetcher;

import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class UserDatafetcher implements DataFetcher<User>{
	
	UserRepository userRepository; 

	@Override
	public User get(DataFetchingEnvironment environment) {
		String id = environment.getArgument("id");
		return userRepository.getOne(id);
	}

}
