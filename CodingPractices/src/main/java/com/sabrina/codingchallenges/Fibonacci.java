package com.sabrina.codingchallenges;

public class Fibonacci {

	public static void main(String[] args) {
		
		
		int currentFib = 0;
        int i = 1;

        while(currentFib < 4000000) {
        	
        	System.out.println(currentFib);
            currentFib = fib(i);
            i++;
        }
	    }

//	    public static int fibEvenSum() {
//
//	        int sum = 0;
//	        int currentFib = 0;
//	        int i = 1;
//
//	        while(currentFib < 4000000) {
//
//	            if(currentFib % 2 == 0) {
//	                sum += currentFib;
//	            }
//
//	            currentFib = fib(i);
//	            i++;
//	        }
//
//	        return sum;
//	    }
	    public static int fib(int term) {

	        if(term == 0) { return 0; }
	        if(term <= 2) { return 1; }
	        
	        return fib(term - 2) + fib(term - 1);
	    }
}
