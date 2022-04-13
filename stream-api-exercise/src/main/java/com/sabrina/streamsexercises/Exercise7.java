package com.sabrina.streamsexercises;

import java.util.List;
import java.time.*; 
import java.util.stream.Collectors;

import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.OrderRepo;

/*
 * Exercise 7 — Get a list of orders which were ordered on 15-Mar-2021, log the order records to the console and then return its product list
You can see that this exercise involves two actions — (1) write order records to the console and (2) produce a list of products. Generating different output from a stream is not possible, how can we fulfill this requirement? Apart from running the stream flow twice, operation peek() allows execution of system logic as part of a stream flow. The sample solution runs peek() to write order records to the console right after data filtering, then subsequent operations such as flatMap() will be executed for the output of product records.*/

public class Exercise7 {
	private OrderRepo orderRepo;
	List<Product> result = orderRepo.findAll()
		    .stream()
		    .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
		    .peek(o -> System.out.println(o.toString()))
		    .flatMap(o -> o.getProducts().stream())
		    .distinct()
		    .collect(Collectors.toList());
	

}
