package com.sabrina.streamsexercises;

import java.util.Map;
import java.util.stream.Collectors;

import space.gavinklfong.demo.streamapi.repos.OrderRepo;

/*
 * Exercise 11 — Obtain a data map with order id and order’s product count
Except for value calculation, all previous exercises just output a record list. The helper class Collectors provide a number of useful operations for data consolidation and data collection output. Let’s check out the exercise to create a data map with order id as the key while the associated value is product count. The terminal operation Collectors.toMap() accepts two arguments for your specify the key and value respectively.*/

public class Exercise11 {
	private OrderRepo orderRepo;

	 Map<Long, Integer>  result = orderRepo.findAll()
		        .stream()
		        .collect(
		            Collectors.toMap(
		                order -> order.getId(),
		                order -> order.getProducts().size()
		                )
		            );
}
