/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int localMax = nums[0];
        int localMin = nums[0];
        int globalMax = nums[0];
        
        for (int i=1; i<nums.length; i++){
            int localMaxCopy = localMax, localMinCopy = localMin;
            localMax = Math.max(nums[i], Math.max(localMaxCopy*nums[i], localMinCopy*nums[i]));
            localMin = Math.min(nums[i], Math.min(localMaxCopy*nums[i], localMinCopy*nums[i]));
            globalMax = Math.max(globalMax, localMax);
        }
        
        return globalMax;
    }
}

