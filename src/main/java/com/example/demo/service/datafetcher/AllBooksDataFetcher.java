package com.example.demo.service.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllBooksDataFetcher implements DataFetcher<List<Book>> {

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> get(DataFetchingEnvironment environment) {
		
		return bookRepository.findAll();
	}

}
