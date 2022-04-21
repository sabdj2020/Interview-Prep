package com.sabrina.codingchallenges;

//the letters A, E, I, O, U, Y, W and sometimes others can all be used to represent vowels.

public class CountVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countVowelsInString("NelyaSarah"));

	}
	
	public static int countVowelsInString(String s) {
		
		int count = 0;
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u' || s.charAt(i)=='y' || s.charAt(i)=='w' 
					|| s.charAt(i)=='A' || s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U' || s.charAt(i)=='Y' || s.charAt(i)=='W') 
			{
				
				count++;
				
			}
		}
		return count;
		
	}

}
