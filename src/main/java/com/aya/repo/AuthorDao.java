package com.aya.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aya.Model.Authors;

@Repository
public class AuthorDao {

	@Autowired
	private AuthorRepository authorRepository;
	
	public void createAuthor(Authors authors) {
		authorRepository.save(authors);
	}
	
}
