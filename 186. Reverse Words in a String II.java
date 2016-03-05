/*
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces and the words are always separated by a single space.
For example,
Given s = "the sky is blue",
return "blue is sky the".
Could you do it in-place without allocating extra space?
*/

public class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
         
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
         
        // Step 2: swap again within a token
        i = 0;
        j = 0;
        while (j < s.length) {
            while (j < s.length && s[j] != ' ') {
                j++;
            }
             
            int m = i;
            int n = j - 1;
            while (m < n) {
                swap(s, m, n);
                m++;
                n--;
            }
             
            i = j + 1;
            j = i;
        }
    }
     
    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}


