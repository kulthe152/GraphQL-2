package com.aya.repo;

import java.util.Random;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.aya.Model.Book;

import reactor.core.publisher.Mono;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
//	@SuppressWarnings("deprecation")
//	@Autowired
//	private DatabaseClient databaseClient;
//	
//	@SuppressWarnings("deprecation")
//	public Mono<Book> getBook(int id) {
//		return databaseClient
//			.select()
//				.from(Book.class)
//					.matching(Criteria.where("id").is(id))
//						.fetch()
//							.one();
//	}
//
//	@SuppressWarnings("deprecation")
//	public Flux<Book> getBooks() {
//		return databaseClient.select().from(Book.class).fetch().all();
//		
//	}

	Book findById(int id);
	
	
	
}
