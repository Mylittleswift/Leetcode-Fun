/**
 *Given a string, determine if a permutation of the string could form a palindrome.
 *For example, "code" -> False, "aab" -> True, "carerac" -> True.
 * Hint:
 * Consider the palindromes of odd vs even length. What difference do you notice? Count the frequency of each character. If each character occurs even number of times, then it must be a palindrome. 
 * How about character which occurs odd number of times?
 */
 

public class Solution {
   public boolean canPermutePalindrome(String s) {
      int n = s.length();
       if (n == 0 || n == 1) {return true;}
       
       int[] count = new int[128];
       int odd = 0;
       for (int i = 0; i < n; i++) {
         count[s.charAt(i)]++;
         }
         
      if (count[s.charAt(i)] % 2 == 1) {odd++;}
       else {odd--;}
    }
        
    return (odd == 0 || odd == 1) ? true : false;
  }
  
  
  
  //hashmap
  public class Solution2 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        // 统计每个字符的个数
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            Integer cnt = map.get(c);
            if(cnt == null){
                cnt = new Integer(0);
            }
            map.put(c, ++cnt);
        }
        // 判断是否只有不大于一个的奇数次字符
        boolean hasOdd = false;
        for(Character c : map.keySet()){
            if(map.get(c) % 2 == 1){
                if(!hasOdd){
                    hasOdd = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
          
      
           
