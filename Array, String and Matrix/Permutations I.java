/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Integer> list = new ArrayList<Integer>();
        dfs(nums, list, result);
        return result;
    }

    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(nums, list, result);
            list.remove(list.size() - 1);
        }
    }
}



//solution2
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
	    result.add(new ArrayList<Integer>());
 
	    for (int i = 0; i < nums.length; i++) {
		    ArrayList<List<Integer>> current = new ArrayList<List<Integer>>();
		    for (List<Integer> l : result) {
		        for (int j = 0; j < l.size()+1; j++) {
				    l.add(j, nums[i]);
				    ArrayList<Integer> temp = new ArrayList<Integer>(l);
				    current.add(temp);
				    l.remove(j);
			    }
		    }
		    result = new ArrayList<List<Integer>>(current);
	    }
	    return result;
    }
}


