/*
Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
*/


public class Solution {
    public void sortColors(int[] nums) {
        int lastZero = -1;
        int lastOne = -1;
        int cur = 0;
        while (cur < nums.length) {
            if (nums[cur] == 1) {
                swap(nums, lastOne + 1, cur);
                lastOne++;
            } else if (nums[cur] == 0) {
                swap(nums, lastZero + 1, cur);
                lastZero++;
                lastOne++;
                if (lastOne > lastZero) {
                    swap(nums, lastOne, cur);
                }
            }
            cur++;
        }
        return;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
}

