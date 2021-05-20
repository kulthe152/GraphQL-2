package com.aya;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.aya.DataFetcher.AllBookDataFetch;
import com.aya.DataFetcher.AuthorDataFetcher;
import com.aya.DataFetcher.BookDataFetch;
import com.aya.DataFetcher.CreateBookService;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.TypeRuntimeWiring;

@SuppressWarnings({ "deprecation", "deprecation" })
@EnableJpaRepositories
@SpringBootApplication
public class GraphQl2Application {
	
//	@Autowired
//	private BookService bookService;
	@Autowired
	AuthorDataFetcher authorDataFetcher;
	@Autowired
	private AllBookDataFetch allBookDataFetch;
	@Autowired
	private BookDataFetch bookDataFetch;
	@Autowired
	private CreateBookService createBookService;
	
	@SuppressWarnings({ "deprecation", "deprecation", "deprecation" })
	public static void main(String[] args) {
		SpringApplication.run(GraphQl2Application.class, args);
	}
	
//	@SuppressWarnings("deprecation")
//	public ConnectionFactoryInitializer connectionFactoryInitialization(ConnectionFactory factory) {
//		
//		@SuppressWarnings("deprecation")
//		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
//		initializer.setConnectionFactory(factory);
//		ResourceDatabasePopulator populator = new ResourceDatabasePopulator(new ClassPathResource("schema.sql"), new ClassPathResource("Data.sql"));
//		initializer.setDatabasePopulator(populator);
//		return initializer;
//	}
	
	//The GraphQL java api intensivley uses the builder pattern.
	@Bean
	public GraphQL graphQL() throws IOException {
		SchemaParser schemaParser = new SchemaParser();
		ClassPathResource schema = new ClassPathResource("schema.graphql");
		TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema.getInputStream());
		
		RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("getBook", bookDataFetch))
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("getBooks", allBookDataFetch))
				.type(TypeRuntimeWiring.newTypeWiring("Mutation").dataFetcher("createBook", createBookService))
				.type(TypeRuntimeWiring.newTypeWiring("Book").dataFetcher("author", authorDataFetcher))				
				.build();
		
		SchemaGenerator generator = new SchemaGenerator();
		GraphQLSchema graphQLSchema = generator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
		return GraphQL.newGraphQL(graphQLSchema).build();		
	}
	
	

}
