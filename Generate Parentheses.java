/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        dfs(result, "", n, n);
        return result;
        }
    public void dfs(ArrayList<String> result, String s, int left, int right) {
        if (left > right) return;
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        } 
        if (left > 0) {
            dfs(result, s + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(result, s + ")", left, right - 1);
        }
    }   
}

