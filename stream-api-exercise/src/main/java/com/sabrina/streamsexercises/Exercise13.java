package com.sabrina.streamsexercises;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.cglib.core.internal.Function;

import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.repos.OrderRepo;


/*
 * Exercise 13 — Produce a data map with order record and product total sum
The data map output this time is not a simple extraction of data fields from the stream, you need to create a sub-stream for each order in order to calculate the product total sum. Since, the key element is the order record itself instead of an order id, so Function.identity() is used to tell Collectors.toMap() to use the data element as the key.*/

public class Exercise13 {
	private OrderRepo orderRepo;
	
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
