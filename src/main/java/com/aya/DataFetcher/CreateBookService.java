package com.aya.DataFetcher;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aya.Constant.Category;
import com.aya.Model.Authors;
import com.aya.Model.Book;
import com.aya.repo.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
@Component
public class CreateBookService implements DataFetcher<Book>{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book get(DataFetchingEnvironment env) throws Exception {
		
//		Random random = new Random();
//		int id = random.nextInt(900)+100;
		
		String bookName = env.getArgument("bookName");
		String authorName = env.getArgument("authorName");
		
		int pages = env.getArgument("pages");
		int age = env.getArgument("age");
		
		Authors authors = new Authors();
		authors.setName(authorName);
		authors.setAge(age);
		
		Category category = Category.valueOf(env.getArgument("category"));
		
		Book book = new Book();
		book.setName(bookName);
		book.setPages(pages);
		book.setAuthors(authors);
		book.setCategory(category);
		
		return bookRepository.save(book);
	}

	
}
