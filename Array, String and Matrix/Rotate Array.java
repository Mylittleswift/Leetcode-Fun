/*
Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
*/

//solution 1 - intermediate array, Space is O(n) and time is O(n)
public class Solution {
	public void rotate(int[] arr, int order) {
		if(order > arr.length) { 
	        order= order % arr.length;
		}
	 
	    int[] result = new int[arr.length];
	 
	    for(int i = 0; i < order; i++){
	        result[i] = arr[arr.length - order + i];
	    }
	 
	    int j = 0;
	    for(int i = order; i< arr.length; i++){
	        result[i] = arr[j];
	        j++;
	    }
	 
	    System.arraycopy( result, 0, arr, 0, arr.length );
	}
}


//solution 2 - Bubble Rotate, Space is O(1) and time is O(n*k)
public class Solution {
	public static void rotate(int[] arr, int order) {
		if (arr == null || order < 0) {
		    throw new IllegalArgumentException("Illegal argument!");
		}
	 
		for (int i = 0; i < order; i++) {
			for (int j = arr.length - 1; j > 0; j--) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}
	}
}


//Solution 3 - Reversal, in-place with O(1) extra space, time O(n)
public class Solution {
    public static void rotate(int[] arr, int order) {
        order = order % arr.length;
        if (arr == null || order < 0) {
	    throw new IllegalArgumentException("Illegal argument!");
        }
        
        //length of first part
	    int a = arr.length - order; 
	    reverse(arr, 0, a-1);
	    reverse(arr, a, arr.length-1);
	    reverse(arr, 0, arr.length-1);
    }
    
    public static void reverse(int[] arr, int left, int right) {
        if (arr == null || arr.length == 1) 
            return;
        
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

