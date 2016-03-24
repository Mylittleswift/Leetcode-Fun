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
        int[] res = new int[2];
    	for (int i = 0; i < nums.length; i++) {
	    for (int j = i + 1; j < nums.length; j++) {
	        if (nums[i] + nums[j] == target) {
		    res[0] = i;
		    res[1] = j;
		}
	    }
    	}
    	return res;
    }
}



//hashmap
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	int[] res = new int[2];
	for (int i = 0; i < nums.length; i++) {
	    if (map.containsKey(nums[i])) {
		res[0] = map.get(nums[i]);
		res[1] = i;
	    } else {
		map.put(target - nums[i], i);
	    }
	}
	return res;
    }
}


