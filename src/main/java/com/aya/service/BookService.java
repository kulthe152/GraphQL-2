package com.aya.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aya.Model.Book;
import com.aya.repo.BookDao;
import com.aya.repo.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorService authorService;
//	public Optional<Book> getBook(){
//		return env ->{
//			int bookId = env.getArgument("id");
//			return bookRepository.findById(bookId) //.getBook(bookId).toFuture();
//		};
//	}
	public Book getBook(DataFetchingEnvironment env) {
		int id = env.getArgument("id");
		return bookRepository.findById(id);
		//return bookRepository.findById(id);
	}
	
//	public DataFetcher<CompletableFuture<List<Book>>> getBooks(){
//		return env -> bookRepository.getBooks().collectList().toFuture();
//	}
	public List<Book> getBooks(DataFetchingEnvironment env){
		List<Book> bookList = bookRepository.findAll();
		return bookList;
	}
	
//	public DataFetcher<Book> createBook() {
//		return env->{
//			String bookName = env.getArgument("bookName");
//			String authorName = env.getArgument("authorName");
//			
//			int pages = env.getArgument("pages");
//			int age = env.getArgument("ages");
//			
//			Book book = new Book(bookName, pages);
//			bookDao.createBook(book).map
//			
//			return null;
//			//bookRepository.save(new Book(name, pages))
//		};
//	}
	
}
