/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return null;
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();  
        List<Integer> subSets = new ArrayList<Integer>();  
        res.add(subSets);  
        if (nums.length == 0) {
            return res; 
        }
        Arrays.sort(nums);  
        int start=0;  
        int l=0;  
        for(int i = 0; i < nums.length; i++) {  
            start = l;  
            if (i != 0 && nums[i] != nums[i - 1]) start = 0;  
            l = res.size();  
            for (int j = start; j < l; j++) {  
                List<Integer> temp = new ArrayList<Integer>(res.get(j));  
                temp.add(nums[i]);  
                res.add(temp);
            }
        } 
        return res;  
    }
}

