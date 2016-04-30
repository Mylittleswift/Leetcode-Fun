/*
Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
*/

//in-place with O(1) extra space
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

