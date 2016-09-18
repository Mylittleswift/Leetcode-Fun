/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

//naive solution, O(n)
public class Solution {
    public int searchInsert(int[] nums, int target) {
         if (nums.length == 0) {
             return 0;
         }
         for (int i = 0; i < nums.length; i++) {
             if (nums[i] >= target) {
                 return i;
             }
         }
         return nums.length;
    }
}

//binary search
public class Solution {
    public int searchInsert(int[] nums, int target) {
        return binaryInsert(nums, target, 0, nums.length - 1);
    }
    
    private int binaryInsert(int[] nums, int target, int lo, int hi) {
        if (lo > hi) {
            return lo;
        }
         
        int mid = (lo + hi) / 2;
        if (target < nums[mid]) {
            return binaryInsert(nums, target, lo, mid - 1);
        } else if (target > nums[mid]) {
            return binaryInsert(nums, target, mid + 1, hi);
        } else {
            return mid;
        }
    }
}

