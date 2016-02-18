 /**
  *Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
  *You may assume that the array is non-empty and the majority element always exist in the array.
  */
  
  //Solution1: Since the majority always take more than a half space, the middle element is guaranteed to be the majority. 
  //Sorting array takes nlog(n). So the time complexity of this solution is nlog(n). 
  
  public int majorityElement(int[] num) {
	   if (num.length == 1) {
	    	return num[0];
    	}
 
   	Arrays.sort(num);
	  return num[num.length / 2];
	  }
	 }
 
 
 //Solution2: Linear Time Majority Vote Algorithm, time complexity is n.
 
 public class Solution {
    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count = 1;
            } else if (result == nums[i]) {
                count++;
            } else {
            count--;
            }
        }
        return result;
    }
}

