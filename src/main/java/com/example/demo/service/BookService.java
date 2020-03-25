package com.example.demo.service;

import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.datafetcher.AllBooksDataFetcher;
import com.example.demo.service.datafetcher.BookDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	 BookDataFetcher BookDataFetcher;
	
	@Autowired
	 AllBooksDataFetcher allBooksDataFetcher;
	
GraphQL graphql;
	
	@Value("classpath:book.graphql")
	Resource resource;

	
	
	@PostConstruct	
	private GraphQL loadData() throws IOException {	
		loadingData();
		RuntimeWiring wiring = CreateRunTimeWiring();
		GraphQLSchema schema = new SchemaGenerator()
		.makeExecutableSchema(new graphql.schema.idl.SchemaParser()
		.parse(resource.getFile()), wiring);		
	return graphql;	
	}


	private void loadingData() {
		
		
		Stream.of(
				new Book("ab12","theprogram guide","conroy",new String[] {"deitel","helin"},"20/12/15"),
				new Book("qw32","how to program java","delroy",new String[] {"jane","toney"},"15/09/18"),
				new Book("64fs","the good path php","stephen",new String[] {"thomas","beters"},"17/03/2010"),
				new Book("64hdg","the road we travelled","duglas",new String[] {"waterman","white"},"23/12/77")
		).forEach(book->{
			bookRepository.save(book);
		});
		
	}


	private RuntimeWiring CreateRunTimeWiring() {
		
		return RuntimeWiring.newRuntimeWiring()
				.type("Query",typeRuntimeWiring->{
				return	typeRuntimeWiring.dataFetcher("allBooks",allBooksDataFetcher)
					.dataFetcher("book",BookDataFetcher);
				})
				.build();
	}
	
	public GraphQL getGraphql() {
		return graphql;
	}

}
