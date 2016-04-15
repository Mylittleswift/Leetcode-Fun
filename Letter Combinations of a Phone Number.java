/*
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(result, map, "", digits);
        return result;
    }
    
    private void helper(List<String> result, HashMap<Character, String> map, String cur, String digits) {
        if (cur.length() == digits.length()) {
            result.add(cur);
            return;
        }
        for (char c : map.get(digits.charAt(cur.length())).toCharArray()) {
            helper(result, map, cur + c, digits);
        }
    }
}

