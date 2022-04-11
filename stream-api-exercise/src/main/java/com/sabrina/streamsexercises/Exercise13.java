package com.sabrina.streamsexercises;

import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.criteria.Order;

import org.springframework.cglib.core.internal.Function;


/*
 * Exercise 13 — Produce a data map with order record and product total sum
The data map output this time is not a simple extraction of data fields from the stream, you need to create a sub-stream for each order in order to calculate the product total sum. Since, the key element is the order record itself instead of an order id, so Function.identity() is used to tell Collectors.toMap() to use the data element as the key.*/

public class Exercise13 {
	
	Map<Order, Double> result = orderRepo.findAll()
	        .stream()
	        .collect(
	          Collectors.toMap(
	              Function.identity(), 
	              order -> order.getProducts().stream()
	                    .mapToDouble(p -> p.getPrice()).sum()
	            ) 
	          );

}
