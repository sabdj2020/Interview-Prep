package com.sabrina.streamsexercises;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

/*
 * 
 * Exercise 14 — Obtain a data map with list of product name by category
This exercise helps you get familiar with the way to transform the data output of data map entries. If you only use Collectors.groupingBy(Product::getCategory), then the output will be Map<Category, List of Products> but the expected output should be Map<Category, List of Product Name>. You can use Collectors.mapping() to convert product objects to product names for the data map construction.*/

public class Exercise14 {
	private ProductRepo productRepo;
	
	Map<String, List<String>> result = productRepo.findAll()
	        .stream()
	        .collect(
	            Collectors.groupingBy(
	                Product::getCategory,
	                Collectors.mapping(product -> product.getName(), Collectors.toList()))
	            );

}
