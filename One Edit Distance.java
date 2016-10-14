/*
Given two strings S and T, determine if they are both one edit distance apart.
*/

//simple solution
public class Solution {
        public boolean isOneEditDistance(String s, String t) {
            int m = s.length(), n = t.length();
            if (m > n) return isOneEditDistance(t, s);
            if (n - m > 1) return false;
            int i = 0, shift = n - m;
            while (i < m && s.charAt(i) = t.charAt(i)) i++;
            if (i == m) return shift > 0;
            if (shift == 0) i++;
            while ((i < m && s.charAt(i) == t.charAt(i + shift)) i++;
            return i == m;
        }
}
                 

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if ((s == null || s.length() == 0) && (t == null || t.length() == 0)) {
            return false;
        }
         
        if (s == null || s.length() == 0) {
            return t.length() == 1;
        }
         
        if (t == null || t.length() == 0) {
            return s.length() == 1;
        }
         
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
         
         
        int count = 0;
        int i = 0;
        int j = 0;
         
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                count++;
                if (count > 1) {
                    return false;
                }
                 
                if (s.length() > t.length()) {
                    i++;
                } else if (s.length() < t.length()) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }
         
        if (i < s.length() || j < t.length()) {
            count++;
        }
         
        return count == 1;
    }
}


