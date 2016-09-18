/*
Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
                if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
 
        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= s) {
              min = Math.min(min, j - i);
              sum -= nums[i++];
            }
        }
    
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}


// A simple sliding window solution
public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
	    if(nums==null || nums.length==1)
	        return 0;
	 
	    int result = nums.length;
	 
	    int start=0;
	    int sum=0;
	    int i=0;
	    boolean exists = false;
	 
	    while(i<=nums.length){
	        if(sum>=s){
	            exists=true; //mark if there exists such a subarray 
	            if(start==i-1){
	                return 1;
	            }
	 
	            result = Math.min(result, i-start);
	            sum=sum-nums[start];
	            start++;
	 
	        }else{
	            if(i==nums.length)
	                break;
	            sum = sum+nums[i];
	            i++;    
	        }
	    }
	 
	    if(exists)
	        return result;
	    else
	        return 0;
	}
}