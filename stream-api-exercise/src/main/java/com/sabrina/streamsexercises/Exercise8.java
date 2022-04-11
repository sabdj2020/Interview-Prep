package com.sabrina.streamsexercises;

/*
 * Exercise 8 — Calculate total lump sum of all orders placed in Feb 2021
All previous exercise was to output a record list by a terminal operation, let’s do some calculation this time. This exercise is to sum up all the products ordered in Feb 2021. As you’ve gone through previous exercises, you can easily obtain the list of products using filter() and flatMap() operations. Next, you can make use of mapToDouble() operation to convert the stream into a stream of data type Double by specifying the price field as the mapping value. At last, terminal operation sum() will help you add up all values and return the total value.*/

public class Exercise8 {
	
	Double result = orderRepo.findAll()
		    .stream()
		    .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
		    .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
		    .flatMap(o -> o.getProducts().stream())
		    .mapToDouble(p -> p.getPrice())
		    .sum();	

}
