package com.aya.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LibrarianService {

	public List<String> getAllLibrarianData(){
		return Arrays.asList("mitali","bhgaya","kirti","shweta");
	}
	
}
