package com.sabrina.streamsexercises;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.criteria.Order;

import space.gavinklfong.demo.streamapi.models.Customer;

/*
 * Exercise 12 — Produce a data map with order records grouped by customer
This exercise is to consolidate a list of orders by customer. Collectors.groupingBy() is a handy function, you can just simply specify what is the key data element, it will then aggregate data for you.*/

public class Exercise12 {
	
	Map<Customer, List<Order>> result = orderRepo.findAll()
	        .stream()
	        .collect(
	            Collectors.groupingBy(Order::getCustomer)
	            );

}
