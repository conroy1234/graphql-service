package com.example.demo.service;

import java.io.File;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.datafetcher.AlluserDatafetcher;
import com.example.demo.service.datafetcher.UserDatafetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class UserService {
	
	GraphQL graphql;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AlluserDatafetcher alluserDatafetcher;
	
	@Autowired
	UserDatafetcher userDatafetcher;
	
	@Value("classpath:User.graphql")
	Resource resource;
	
	@PostConstruct
	public GraphQL createCraphql() {
		loadSchema();
		try {
		File file = resource.getFile();
		TypeDefinitionRegistry registry = new graphql.schema.idl.SchemaParser().parse(file);
		RuntimeWiring wiring = createWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry, wiring);
		graphql = GraphQL.newGraphQL(schema).build();
		}catch(Exception e) {
			System.out.println("exception is **********************"+e.getMessage());
		}
		return graphql;
		
	}

	private RuntimeWiring createWiring() {		
		return RuntimeWiring.newRuntimeWiring()
				.type("Query",typeWiring->typeWiring
				.dataFetcher("allUsers", alluserDatafetcher)
				.dataFetcher("user", userDatafetcher))
						
				.build();
	}
	
	private GraphQL loadSchema() {
		Stream.of(new User("1","conroy white","dagenham","conroyaw@gmail.com","07930341651"),
				new User("2","timothy","Usa","timothy.white@gmail.com","01247856974"),
				new User("3","joanne","Watford","coan@gmail.com","012457896")
				).forEach(user ->{
					userRepository.save(user);
				});
		return graphql;
		
		
	}

}
