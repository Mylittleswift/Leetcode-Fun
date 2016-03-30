 /**
  *Given two strings s and t, write a function to determine if t is an anagram of s.
  *For example,
  *s = "anagram", t = "nagaram", return true.
  *s = "rat", t = "car", return false.
  *Note: You may assume the string contains only lowercase alphabets.
  */
  
  
 /**
  *Solution1: use a constant length array to store for the characters.
  *Time Complexity: O(n)
  *Space Complexity: O(1)
  */
 public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a'] += 1;
            letters[t.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }
        return true;
    }
}


 /**
  *Solution2:
  *first sort the two String, and compare each index.
  *Time Complexity: O(nlogn)
  *Space Complexity: O(1)
  */
 public class Solution {
        public boolean isAnagram(String s, String t) {
            char[] schar = s.toCharArray();
            char[] tchar = t.toCharArray();
            Arrays.sort(schar);
            Arrays.sort(tchar);
            s = new String(schar);
            t = new String(tchar);
            return s.equals(t);
        }
    }



