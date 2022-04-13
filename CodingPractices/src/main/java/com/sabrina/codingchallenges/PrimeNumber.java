package com.sabrina.codingchallenges;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String input = scanner.next();
			int n = Integer.parseInt(input);
			System.out.println(isPrime(n));
		}
		

	}
	
	public static boolean isPrime(int n) {
		if(n==0 || n==1) {
			return false;
		}
		if (n==2) {
			return true;
		}
		
		for(int i=2; i<n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;

		
	}

}
