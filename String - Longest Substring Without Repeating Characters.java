/*
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

//solution1
public class Solution {
    public int lengthOfLongestSubstring(String s) {
      boolean[] exist = new boolean[256];
       int i = 0, maxLen = 0; //substring(i,j)
       for (int j = 0; j < s.length(); j++) {
          while (exist[s.charAt(j)]) {
             exist[s.charAt(i)] = false;
             i++;
          }
          exist[s.charAt(j)] = true;
          maxLen = Math.max(j - i + 1, maxLen);
       }
       return maxLen;
    }
}


//solution2
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0) 
            return 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int i = 0; //start index of the potential longest substring
        int j = 0; //cur index 
        int maxLen = 0;
        while (j<s.length()){
            while (map.containsKey(s.charAt(j))){
                map.remove(s.charAt(i));
                i=i+1;
            }
            map.put(s.charAt(j),j);
            maxLen = Math.max(j-i+1,maxLen);
            j++;
        }
        return maxLen;
    }
}

