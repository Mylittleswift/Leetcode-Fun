/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/


public class Solution {
    public int[] singleNumber(int[] nums) {
         if (nums == null || nums.length == 0) {
            return new int[0];
        }
         
        // Step 1: calculate the xor for all numbers
        // So the result is the xor of the two single numbers
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
         
        // Step 2: find the first bit 1 from right
        int last1bit = 1;
        while ((last1bit & xor) == 0) {
            last1bit = last1bit << 1;
        }
        
        int xor1 = 0;
        int xor2 = 0;
        for (int num : nums) {
            if ((num & last1bit) == 0) {
                xor1 ^= num;
            } else {
                xor2 ^= num;
            }
        }
        
        int[] result = new int[]{xor1, xor2};
        return result;
    }
}

