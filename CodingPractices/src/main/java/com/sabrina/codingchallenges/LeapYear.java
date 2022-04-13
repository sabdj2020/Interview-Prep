package com.sabrina.codingchallenges;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String s = scanner.nextLine();
			System.out.println(isLeapYear(Integer.parseInt(s)));
		}
	}
	
	public static boolean isLeapYear(int year) {
		if((year%4==0 && year%100!=0)||(year%400==0)) {
			return true;
		}
		return false;
	}

}
