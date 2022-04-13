package com.sabrina.streamsexercises;

import space.gavinklfong.demo.streamapi.repos.OrderRepo;
import java.time.*; 


/*
 * Exercise 9 — Calculate order average payment placed on 14-Mar-2021
In addition to total sum, stream API offers operation for average value calculation as well. You might find that the return data type is different from sum() as it is an Optional data type. The reason is that the data stream would be empty and so calculation won’t output an average value for a empty data stream.*/

public class Exercise9 {
	
	private OrderRepo orderRepo;

	Double result = orderRepo.findAll()
	        .stream()
	        .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
	        .flatMap(o -> o.getProducts().stream())
	        .mapToDouble(p -> p.getPrice())
	        .average().getAsDouble();
}
