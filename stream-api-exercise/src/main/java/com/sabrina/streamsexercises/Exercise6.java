package com.sabrina.streamsexercises;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.Order;

/*
 * Exercise 6 — Get the 3 most recent placed order
Similar to previous exercise, the obvious solution is to sort the order records by order date field. The tricky part is that the sorting this time should be in descending order such that you can obtain the order records with the most recent order date. It can be achieved simply by calling Comparator.reversed().*/

public class Exercise6 {
	
	List<Order> result = orderRepo.findAll()
	        .stream()
	        .sorted(Comparator.comparing(Order::getOrderDate).reversed())
	        .limit(3)
	        .collect(Collectors.toList());

}
