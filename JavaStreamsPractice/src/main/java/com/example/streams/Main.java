package com.example.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people = getPeople();
		
		//Imperative approach
		List <Person> female = new ArrayList<>();
		
		for (Person person : people) {
			if(person.getGender().equals(Gender.FEMALE)) {
				female.add(person);
			}
		}
//		for (Person person: female) {
//			System.out.println(person);
//		}
		
		female.forEach(System.out::println);
		
		//Declarative approach--streams are meant for collection
		
		//filter
		System.out.println("print females using streams");
		List<Person> females = people.stream()
		.filter(person -> person.getGender().equals(Gender.FEMALE))
		.collect(Collectors.toList());
		females.forEach(System.out::println);
		
		//sort
		System.out.println("person  sorted by age");
		List <Person> sortedByAge =people.stream()
		.sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
		.collect(Collectors.toList());
		sortedByAge.forEach(System.out::println);
		
		//all match
		boolean allMatch = people.stream()
		.allMatch(person -> person.getAge()>=1);
		System.out.println(allMatch);
		
		//any match
		boolean anyMatch = people.stream()
		.anyMatch(person -> person.getAge()>5);
		System.out.println(anyMatch);
		//none match
		
		boolean noneMatch = people.stream().noneMatch(person -> person.getName().equals("zizou"));
		System.out.println(noneMatch);
		//max
		
		people.stream().max(Comparator.comparing(Person :: getAge))
		.ifPresent(System.out::println);
		//min
		people.stream().min(Comparator.comparing(Person::getAge))
		.ifPresent(System.out::println);;
		//group
		Map<Gender, List<Person>> map = people.stream()
		.collect(Collectors.groupingBy(Person::getGender));
		
		map.forEach((gender, p)->{
		System.out.println(gender);
		p.forEach(System.out::println);
		});
		
		//oldest female
		Optional<String> oldestFemale = people.stream()
		.filter(person -> person.getGender().equals(Gender.FEMALE))
		.max(Comparator.comparing(Person::getAge))
		.map(Person::getName);
		oldestFemale.ifPresent(System.out::println);

	}

	private static List<Person> getPeople() {
		return List.of(
				new Person(35, "Sabrina", Gender.FEMALE),
				new Person (34, "Nourdine", Gender.MALE),
				new Person (4, "Nelya", Gender.FEMALE),
				new Person (1, "Sarah", Gender.FEMALE),
				new Person (58, "Ghania", Gender.FEMALE)
				);
	}

}
