package com.sabrina.codingchallenges;

import java.util.Scanner;

public class Palindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			Scanner scanner = new Scanner(System.in);
			String s = scanner.nextLine();
			System.out.println(isPalindrom(s));
		}

	}
	
	public static boolean isPalindrom(String s) {
		
		for(int i=0; i<s.length()/2; i++) {
			if(s.charAt(i)!=s.charAt(s.length()-i-1)) {
				return false;
			}	
		}
		return true;
		
	}

}
