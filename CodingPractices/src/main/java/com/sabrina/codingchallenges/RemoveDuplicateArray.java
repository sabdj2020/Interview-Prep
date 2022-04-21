package com.sabrina.codingchallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = new Integer []{1,1,5,1,3,3,4,3,1};
		removeDuplicate(a);
	}
	
	public static void removeDuplicate(Integer[] a) {
		List l = Arrays.asList(a);
		HashSet<Integer>set = new HashSet<Integer>(l);
	    l = new ArrayList<Integer>(set);
		System.out.println(l);
	}
}
