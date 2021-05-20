package com.aya.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aya.Model.Book;

@Repository
public class BookDao {

	@Autowired
	private BookRepository bookRepository;
	
	public void createBook(Book book) {
		bookRepository.save(book);
	}
	
}
