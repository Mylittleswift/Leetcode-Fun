/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.
Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},
    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Bad solution: Time Limit Exceeded!
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> each = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) { // too much loops
                  if (nums[i] + nums[j] + nums[k] == 0) {
                      each.add(nums[i]);
                      each.add(nums[j]);
                      each.add(nums[k]);
                      result.add(each);
                      each.clear();
                  }
                }
            }
        }
        return result;
    }
}


//solution2
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
	    if (nums.length < 3) {
	        return result;
	    }
	    Arrays.sort(nums);
	    
	    for (int i = 0; i < nums.length - 2; i++) {
	        if (i == 0 || nums[i] > nums[i - 1]) {
		        int negate = -nums[i];
		        int start = i + 1;
		        int end = nums.length - 1;
		        while (start < end) {
		            //case 1
		            if (nums[start] + nums[end] == negate) {
			            ArrayList<Integer> temp = new ArrayList<>();
			            temp.add(nums[i]);
			            temp.add(nums[start]);
			            temp.add(nums[end]);
			            result.add(temp);
			            start++;
			            end--;
			            while (start < end && nums[end] == nums[end + 1])
			                end--;
                        while (start < end && nums[start] == nums[start - 1])
			                start++;
			            //case 2
		                } else if (nums[start] + nums[end] < negate) {
			                start++;
			            //case 3
		                } else {
			                end--;
		                }
		          }
	        }
	    }
	    return result;
    }
}

