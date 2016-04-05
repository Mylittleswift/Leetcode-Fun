/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

//O(n^2)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < nums.length -1; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

//O(NlogN)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        ArrayList<Integer> lis = new ArrayList<Integer>();
        for (int n : nums) {
            if (lis.size() == 0 || lis.get(lis.size() - 1) < n) {
                lis.add(n);
            } else {
                updateLIS(lis, n);
            }
        }
        return lis.size();
    }
    
    private void updateLIS(ArrayList<Integer> lis, int n) {
        int l = 0, r = lis.size() - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (lis.get(m) < n) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        lis.set(l, n);
    }
}

