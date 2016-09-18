/*
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
*/

public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
         
        Arrays.sort(nums);
        int n = nums.length;
         
        int[] temp = new int[n];
        int left = (n - 1) / 2;
        int right = n - 1;
         
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                temp[i] = nums[left];
                left--;
            } else {
                temp[i] = nums[right];
                right--;
            }
        }
         
        System.arraycopy(temp, 0, nums, 0, n);
        
    }
}

