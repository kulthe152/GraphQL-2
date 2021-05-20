package com.aya.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aya.Model.GraphQLRequestBody;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import reactor.core.publisher.Mono;

@RestController
public class GraphQLController {

	@Autowired
	private GraphQL graphql;

	@PostMapping(value = "graphqll", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Mono<Map<String,Object>> execute(@RequestBody GraphQLRequestBody body) 
	{
		return Mono.fromCompletionStage(graphql.executeAsync(ExecutionInput.newExecutionInput().query(body.getQuery())
				.operationName(body.getOperationName()).variables(body.getVariables()).build()))
				.map(ExecutionResult::toSpecification);
	}
	
	

}
