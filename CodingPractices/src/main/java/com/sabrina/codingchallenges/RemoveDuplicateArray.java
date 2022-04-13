package com.sabrina.codingchallenges;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int []{1,1,5,1,3,3,4,3,1};
		removeDuplicate(a);
		for(int i=0; i<a.length;i++) {
			System.out.print(a[i] + " ");
		}

	}
	
	public static void removeDuplicate(int[] a) {
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i<a.length; i++) {
			set.add(a[i]);
		}
	}

}
