 /**
  *Given a non-negative number represented as an array of digits, plus one to the number.
  *The digits are stored such that the most significant digit is at the head of the list.
  */
  
  public class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1;
        for (int i = digits.length - 1; i >= 0 && c > 0; i--) {
            int d = digits[i] + 1;
            digits[i] = d % 10;
            c = d / 10;
        }
    
        if (c > 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits; 
    }
}

