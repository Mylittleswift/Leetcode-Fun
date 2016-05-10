/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.
For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
The number of ways decoding "12" is 2.
*/

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        int preDigit = 0;
        for (int i = 1; i <= s.length(); i++) {
            int curDigit = s.charAt(i - 1) - '0';
            if (curDigit != 0) {
                dp[i] += dp[i - 1]; 
            }
            if (preDigit > 0 && 10 * preDigit + curDigit <= 26) {
                dp[i] += dp[i - 2];
            }
            preDigit = curDigit;
        }
        return dp[s.length()];
    }
}

