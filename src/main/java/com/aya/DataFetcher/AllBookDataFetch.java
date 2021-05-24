package com.aya.DataFetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aya.Model.Book;
import com.aya.repo.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
@Component
public class AllBookDataFetch implements DataFetcher<List<Book>>{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> get(DataFetchingEnvironment environment) throws Exception {
		return bookRepository.findAll();
	}
	
	public void businesslogic_44452() {
		System.out.println("Business Logic executed 44452");
	}

	
}
