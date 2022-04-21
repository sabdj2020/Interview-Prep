package com.sabrina.streamsexercises;

import java.util.List;
import java.util.stream.Collectors;

import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

/* Exercise 1 — Obtain a list of products belongs to category “Books” with price > 100
This is obviously a filtering logic, the output should fulfill the two filtering requirements. So, you can apply 2 filter() operations to obtain the result. */


public class Exercise1 {
	private ProductRepo productRepo;
	List<Product> result = productRepo.findAll()
			  .stream()
			  .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
			  .filter(p -> p.getPrice() > 100)
			  .collect(Collectors.toList());

}
