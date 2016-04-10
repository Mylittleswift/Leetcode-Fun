/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.
Note: The sequence of integers will be represented as a string.
*/

public class Solution {
    public String countAndSay(int n) {
        String say = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder cur = new StringBuilder();
            for (int j = 0; j < say.length(); j++) {
                char c = say.charAt(j);
                j++;
                int count = 1;
                while (j < say.length() && say.charAt(j) == c) {
                    j++;
                    count++;
                }
                j--;
                cur.append(count);
                cur.append(c);
            }
            say = cur.toString();
        }
        return say;
    }
}

