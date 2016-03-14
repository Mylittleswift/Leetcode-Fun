/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/


public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        // dp
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                }
            }
        }
        // backtracking
        helper(s, isPalindrome, result, new ArrayList<String>(), 0);
        return result;
    }
    
    private void helper(String s, boolean[][] isPalindrome, List<List<String>> result, List<String> curList, int ind) {
        if (ind == s.length()) {
            result.add(new ArrayList<String>(curList));
            return;
        }
        for (int i = ind; i < s.length(); i++) {
            if (isPalindrome[ind][i]) {
                curList.add(s.substring(ind, i + 1));
                helper(s, isPalindrome, result, curList, i + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }
}


  
  
