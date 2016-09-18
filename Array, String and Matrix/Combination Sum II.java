/*
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void helper(int[] candidates, int start, int target, List<Integer> item, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            item.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], item, result);
            item.remove(item.size() - 1);
        }
    }
}


