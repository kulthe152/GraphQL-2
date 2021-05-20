package com.aya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aya.Model.Authors;
import com.aya.Model.Book;
import com.aya.repo.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
//	public void createAuthor(String authorName, int age, Book book) {
//		Authors authors = new Authors();
//		authors.setAge(age);
//		authors.setName(authorName);
//		authors.setBook(book);
//		authorRepository.save(authors);
//	}
	
}
