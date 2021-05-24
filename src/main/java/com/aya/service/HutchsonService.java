package com.aya.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HutchsonService {

	public List<String> getHutchsonCustomerData(){
		return Arrays.asList("Customer-1","Customer-2","Customer-3","Customer-4");		
	}
	
}
