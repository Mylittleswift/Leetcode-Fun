/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int c = 0, i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 && j >= 0) {
            int sum = (int) (a.charAt(i) - '0') + (int) (b.charAt(j) - '0') + c;
            c = sum / 2;
            sb.append(sum % 2);
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = (int) (a.charAt(i) - '0') + c;
            c = sum / 2;
            sb.append(sum % 2);
            i--;
        }
        while (j >= 0) {
            int sum = (int) (b.charAt(j) - '0') + c;
            c = sum / 2;
            sb.append(sum % 2);
            j--;
        }
        if (c != 0) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}

