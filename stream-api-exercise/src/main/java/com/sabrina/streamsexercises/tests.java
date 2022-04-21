package com.sabrina.streamsexercises;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.CustomerRepo;
import space.gavinklfong.demo.streamapi.repos.OrderRepo;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

public class tests {
	
private ProductRepo productRepo;
private OrderRepo orderRepo;
private CustomerRepo customerRepo;

/* Exercise 1 — Obtain a list of products belongs to category “Books” with price > 100
This is obviously a filtering logic, the output should fulfill the two filtering requirements. So, you can apply 2 filter() operations to obtain the result. */

List<Product> productsByCatPrice = productRepo.findAll().stream().
filter(p->p.getPrice()>100)
.filter(p->p.getCategory().equals("xxx"))
.collect(Collectors.toList());

/*Exercise 2 — Obtain a list of order with products belong to category “Baby”
You need to start from the data flow from the order entities and then check if order’s products belong to the category “Baby”. Hence, the filter logic looks into the products stream of each order record and use anyMatch() to determine if any product fulfill the criteria.*/

List<Order> orders = orderRepo.findAll()
                              .stream()
                              .filter(o->o.getProducts()
                            		  .stream()
                            		  .anyMatch(p->p.getCategory().equalsIgnoreCase("baby"))
                            		  )
                              .collect(Collectors.toList());

/*Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount
In this exercise, you will see how to transform data using the stream API. After you’ve obtained a product list with a category that belongs to “Toys” using filter(), you can then apply a 10% discount to the product price by using map().*/

List<Product> products = productRepo.findAll().stream()
                                              .filter(p->p.getCategory().equalsIgnoreCase("toys"))
                                              .map(p->p.withPrice(p.getPrice()*0.9))
                                              .collect(Collectors.toList());

/*Exercise 4 — Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
This exercise illustrates the usage of flatMap(). You can firstly start from an order list and then filter the list by customer tier and order date. Next, get the product list from each order record and use flatMap() to emit product records into the stream. For example, if we have 3 order records and each order contains 10 products, then flatMap() will emit 10 data elements for each order record, resulting in 30 (3 x 10) product record output in the stream.
Since product list would contain duplicated product records if multiple orders would include the same product. In order to generate a unique product list, applying distinct() operation can help to produce the unique list.*/

List<Product> products2 = orderRepo.findAll()
                                    .stream()
                                    .filter(o->o.getCustomer().getTier() == 2)
                                    .filter(o->o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1))>=0)
                                    .filter(o->o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1))<=0)
                                    .flatMap(o->o.getProducts().stream())
                                    .distinct()
                                    .collect(Collectors.toList());
}
