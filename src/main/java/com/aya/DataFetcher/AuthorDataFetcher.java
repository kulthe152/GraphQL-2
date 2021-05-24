package com.aya.DataFetcher;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aya.Model.Authors;
import com.aya.Model.Book;
import com.aya.repo.AuthorRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
@Component
public class AuthorDataFetcher implements DataFetcher<Authors> {

	@Autowired
	AuthorRepository authorRepository;

	@Override
	public Authors get(DataFetchingEnvironment env) throws Exception {
		Book book = env.getSource();
		Authors authors = authorRepository.findById(book.getAuthors().getId());
		return authors;
	}
}