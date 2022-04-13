package com.sabrina.streamsexercises;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

/*
 * Exercise 15 — Get the most expensive product by category
Similar to data transformation using Collectors.mapping(), Collectors.maxBy() helps to obtain the record with max value as part of data map construction. By providing a comparator for product price, maxBy() is able to get the product with the largest value for each category.
*/
public class Exercise15 {
	private ProductRepo productRepo;
	
	Map<String, Optional<Product>> result = productRepo.findAll()
	        .stream()
	        .collect(
	            Collectors.groupingBy(
	                Product::getCategory,
	                Collectors.maxBy(Comparator.comparing(Product::getPrice))));

}
