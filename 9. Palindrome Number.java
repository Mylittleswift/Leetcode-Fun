 /**
  *Determine whether an integer is a palindrome. Do this without extra space.
  */
  
  public class Solution {
    public boolean isPalindrome(int x) {
        int palindromeX = 0;
        int input = x;
        while (x > 0) {
            palindromeX = palindromeX * 10 + (x % 10);
            x /= 10;
        }
        return palindromeX == input;
    }
}

