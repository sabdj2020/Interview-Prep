package com.sabrina.streamsexercises;

import java.util.DoubleSummaryStatistics;

import space.gavinklfong.demo.streamapi.repos.ProductRepo;

/*
 * 
 * Exercise 10 — Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category “Books”
What if you need to get sum, average, max, min and count at the same time? Should we run the data stream 5 times to get those figures one by one? Such an approach is not quite effective. Luckily, stream API provides a convenient way to get all those values at once by using terminal operation summaryStatistics(). It returns a data type DoubleSummaryStatistics which contains all the required figures.*/

public class Exercise10 {
	private ProductRepo productRepo;
	
	DoubleSummaryStatistics statistics = productRepo.findAll()
		    .stream()
		    .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
		    .mapToDouble(p -> p.getPrice())
		    .summaryStatistics();
		  
		  System.out.println(String.format("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f", 
		    statistics.getCount(), statistics.getAverage(), statistics.getMax(), statistics.getMin(), statistics.getSum()));
		  


}
