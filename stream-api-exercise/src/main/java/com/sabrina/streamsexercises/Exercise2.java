package com.sabrina.streamsexercises;

import java.util.List;
import java.util.stream.Collectors;

import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.repos.OrderRepo;

/*Exercise 2 — Obtain a list of order with products belong to category “Baby”
You need to start from the data flow from the order entities and then check if order’s products belong to the category “Baby”. Hence, the filter logic looks into the products stream of each order record and use anyMatch() to determine if any product fulfill the criteria.*/

public class Exercise2 {
	private OrderRepo orderRepo;
	List<Order> result = orderRepo.findAll()
	        .stream()
	        .filter(o -> 
	          o.getProducts()
	          .stream()
	          .anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby"))
	        )
	        .collect(Collectors.toList());  

}
