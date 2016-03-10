/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

//naive solution
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
    	for (int i = 0; i < nums.length; i++) {
	        for (int j = i + 1; j < nums.length; j++) {
			    if (nums[i] + nums[j] == target) {
				    ret[0] = i;
				    ret[1] = j;
			    }
	        }
    	}
    	return ret;
    }
}



//hashmap
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    int[] result = new int[2];
	    
	    for (int i = 0; i < nums.length; i++) {
		if (map.containsKey(nums[i])) {
			result[0] = map.get(nums[i]);
			result[1] = i;
		} else {
			map.put(target - nums[i], i);
		}
	}
	return result;
    }
}


