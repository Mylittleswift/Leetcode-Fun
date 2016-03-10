/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
       	int[] ret = {-1, -1};
 
	    // the first binary search to find the left boundary
	    int l = 0, r = nums.length - 1;
	    while (l < r) {
	        int mid = (l + r) / 2;
	        if (nums[mid] < target) {
	            l = mid + 1;
	            } else {
	                r = mid;
	            }
	    }
 
	    // if target can not be found, return {-1, -1}
	    if (nums[l] != target) {
	        return ret;   
	    }
		
 
	    ret[0] = l;
	    // second binary search to find the right boundary
	    r = nums.length - 1;
	    while (l < r) {
		    // mid is calculated differently
		    int mid = (l + r + 1) / 2;
		    if (nums[mid] > target) {
		        r = mid - 1;
		        } else {
		            l = mid;
		        }
	    }
	    ret[1] = l;
	    return ret;
    }
}

