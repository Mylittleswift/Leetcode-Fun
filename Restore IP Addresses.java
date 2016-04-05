/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        helper(result, s, "", 0, 0);
        return result;
    }
    
    private void helper(List<String> result, String s, String p, int cur, int count) {
        if (count == 4 || cur == s.length()) {
            if (count == 4 && cur == s.length()) {
                result.add(p);
            }
            return;
        }
        String delimeter = "";
        if (count < 3) {
            delimeter = ".";
        }
        helper(result, s, p + s.charAt(cur) + delimeter, cur + 1, count + 1);
        if (cur + 1 < s.length() && s.charAt(cur) != '0') {
            helper(result, s, p + s.substring(cur, cur + 2) + delimeter, cur + 2, count + 1);
        }
        if (cur + 2 < s.length() && s.charAt(cur) != '0' && Integer.parseInt(s.substring(cur, cur + 3)) <= 255) {
            helper(result, s, p + s.substring(cur, cur + 3) + delimeter, cur + 3, count + 1);
        }
    }
}

