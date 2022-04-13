package com.sabrina.codingchallenges;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] {1,6,8,14,12,6};
		bubbleSort (a);
		for(int i = 0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		

	}
	
	public static void bubbleSort(int [] a) {
		
		for(int i=0; i<a.length-1; i++) {
			int temp=0;
			for(int j=i+1; j<a.length; j++) {
				if(a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
	}

}
