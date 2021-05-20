package com.aya.DataFetcher;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aya.Model.Book;
import com.aya.repo.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class BookDataFetch implements DataFetcher<Book>{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book get(DataFetchingEnvironment environment) throws Exception {
		int id = environment.getArgument("id");
		return bookRepository.findById(id);
	}

	
}
