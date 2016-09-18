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
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, k, n, 1, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(List<List<Integer>> result, int k, int remSum, int minValue, List<Integer> list) {
        if (list.size() == k) {
            if (remSum == 0) {
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for (int i = minValue; i <= remSum && i <= 9; i++) {
            list.add(i);
            helper(result, k, remSum - i, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}

