/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
For example,
If n = 4 and k = 2, a solution is:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, n, k, 1, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(List<List<Integer>> result, int n, int k, int curI, ArrayList<Integer> curList) {
        if (curList.size() == k) {
            result.add(new ArrayList<>(curList));
            return;
        }
        for (int i = curI; i <= n; i++) {
            curList.add(i);
            helper(result, n, k, i + 1, curList);
            curList.remove(curList.size() - 1);
        }
    }
}

