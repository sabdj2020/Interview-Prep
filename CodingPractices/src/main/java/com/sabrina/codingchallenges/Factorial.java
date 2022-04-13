package com.sabrina.codingchallenges;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findFactorial(4));

	}
	
	public static int findFactorial(int n) {
		
		if(n==0 || n==1) {
			return 1;
		}
		return n * findFactorial(n-1);
		
	}

}
