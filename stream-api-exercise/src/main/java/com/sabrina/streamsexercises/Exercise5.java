package com.sabrina.streamsexercises;

import java.util.Comparator;
import java.util.Optional;

import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

/*
 * Exercise 5 — Get the cheapest products of “Books” category
One of the effective ways to obtain the product with the lowest price is to sort the product list by price in an ascending order and get the first element. Java Stream API provides sorted() operation for stream data sorting based on specific field attributes. In order to obtain the first element in the stream, you can use the terminal operation findFirst(). The operation returns the first data element wrapped by Optional as it is possible that the output stream can be empty.
This solution can only return a single product record with the lowest price. If there are multiple product records with the same lowest price, the solution should be modified such that it looks for the lowest price amount first and then filters product records by the price amount so as to get a list of products with the same lowest price.*/

public class Exercise5 {
	private ProductRepo productRepo;
	
	Optional<Product> result = productRepo.findAll()
	        .stream()
	        .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
	        .sorted(Comparator.comparing(Product::getPrice))
	        .findFirst();
	
	
	//update
	
	Optional<Product> resultUpdated = productRepo.findAll()
	        .stream()
	        .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
	        .min(Comparator.comparing(Product::getPrice));

}
