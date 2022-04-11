package com.sabrina.streamsexercises;

import java.util.List;
import java.util.stream.Collectors;

import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

/*Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount
In this exercise, you will see how to transform data using the stream API. After you’ve obtained a product list with a category that belongs to “Toys” using filter(), you can then apply a 10% discount to the product price by using map().*/

public class Exercise3 {
	private ProductRepo productRepo;
	
	List<Product> result = productRepo.findAll()
	        .stream()
	        .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
	        .map(p -> p.withPrice(p.getPrice() * 0.9))
	        .collect(Collectors.toList());  
	  

}
