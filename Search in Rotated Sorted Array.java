/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/


public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] < nums[r]) { //A[m...r] are sorted
                if (nums[m] < target && target <= nums[r]) { 
                    l = m + 1; //target is in A[m+1...r]
                } else {
                    r = m - 1; //target is in A[l...m-1]
                }
            } else { //A[l...m] are sorted
                if (nums[m] > target && target >= nums[l] ) {
                    r = m - 1; //target is in A[l...m-1]
                } else {
                    l = m + 1; //target is in A[m+1...r]
                }
            }
        }
        return nums[l] == target ? l : -1;
    }
}

