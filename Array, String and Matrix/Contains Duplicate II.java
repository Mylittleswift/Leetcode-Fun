/**
 *Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array 
 *such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
 
 public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(nums[i])) <= k)
                    return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}


 
 //solution 2
 public class Solution {
	 public boolean containsNearbyDuplicate(int[] nums, int k) {
		    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		    int min = Integer.MAX_VALUE;
		 
		    for(int i=0; i<nums.length; i++){
		        if(map.containsKey(nums[i])){
		            int preIndex = map.get(nums[i]);
		            int gap = i-preIndex;
		            min = Math.min(min, gap);
		        }
		        map.put(nums[i], i);
		    }
		 
		    if(min <= k){
		        return true;
		    }else{
		        return false;
		    }
		}
 }