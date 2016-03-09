/*
Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, result, new ArrayList<Integer>(), 0, target);
        return result;        
    }
    
    private void helper(int[] candidates, List<List<Integer>> result, ArrayList<Integer> list, int cur, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = cur; i < candidates.length && candidates[i] <= target; i++) {
            list.add(candidates[i]);
            helper(candidates, result, list, i, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}

