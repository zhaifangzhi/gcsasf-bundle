package com.model;

import java.util.Arrays;

public class Sort {

	public static void quickSort(long[] arr, int low, int high){
	    if(arr.length <= 0) return;
	    if(low >= high) return;
	    int left = low;
	    int right = high;

	    long temp = arr[left];   
	    while (left < right){
	        while(left < right && arr[right] >= temp){  
	            right--;
	        }
	        arr[left] = arr[right];
	        while(left < right && arr[left] <= temp){  
	            left++;
	        }
	        arr[right] = arr[left];
	    }
	    arr[left] = temp;   
	    System.out.println("Sorting: " + Arrays.toString(arr));
	    quickSort(arr, low, left-1);
	    quickSort(arr, left+1, high);
	}

}
