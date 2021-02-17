package com.posco.pramp.arrayIndexEquality;

import java.util.Arrays;

public class IndexEqualsValueSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000;
		int key = 17;
		int[] a = randomSortedArrayLengthN(n);
		System.out.println(Arrays.toString(a));
		System.out.println(
				findIndexWhereValueMatchesIndex(a, key)
				);
		int index = findIndexWhereValueMatchesIndex(a, key);
		System.out.println();
		System.out.println("index " + index + " = " + (index > 0 ? a[index] : " not found!"));
		
	}
	
	public static int findIndexWhereValueMatchesIndex(int[] arr, int key) {
	    int start = 0;
	    int end = arr.length - 1;
		int mid;

		while (start <= end) {
			mid = Math.round((start+end)/2); 		// check-point at array middle
			if      (key < arr[mid])   end = mid-1; // search array's RHS
			else if (key > arr[mid]) start = mid+1; // search array's LHS
			else return mid;
		}
	    return -1;
	}

	
	
	private static int[] randomSortedArrayLengthN(int n) {
		int[] intArray = new int[n];
		double x = 0;

		for (int i = 0; i < n; i++) {
			x = Math.random() * 1000;
			intArray[i] = (int) Math.floor(x);
		}
		Arrays.sort(intArray);
		return intArray; 
	}
}
