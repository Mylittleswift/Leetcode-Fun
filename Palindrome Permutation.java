
/*
Given a string, determine if a permutation of the string could form a palindrome.
For example,
"code" -> False, "aab" -> True, "carerac" -> True.
Hint:
Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
Tags: Hash Table
Similar Problems: (M) Longest Palindromic Substring, (E) Valid Anagram, (M) Palindrome Permutation II
*/


//solution1: hashmap
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < s.length(); i++) {
            String str = s.charAt(i) + "";
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }//ENd for
        int countOdd = 0; 
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                countOdd++;
            }
            if (countOdd > 1) {
                return false;
            }
        }//END for
        return true;
    }
}




//solution2
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a'] += 1;
        }
        int countOne = 0;
        for (int count : counts) {
            if (count == 1 && countOne >= 1) {
                return false;
            } else if (count == 1) {
                countOne++;
            } else if (count % 2 != 0) {
                return false;
            }
        }
        
        return true;
    }
}


//solution3: hashset
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            // 出现的第偶数次，将其从Set中移出
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
            } else {
            // 出现的第奇数次，将其加入Set中
                set.add(s.charAt(i));
            }
        }
        // 最多只能有一个奇数次字符
        return set.size() <= 1;
    }
}

