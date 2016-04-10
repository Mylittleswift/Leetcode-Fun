 /**
  * Given a column title as appear in an Excel sheet, return its corresponding column number.
  */
  
  public class Solution {
    public int titleToNumber(String s) {
        int col = 0;
        for (int i = 0; i < s.length(); i++) {
            col = col * 26 + s.charAt(i)-'A' + 1; // 'A' to 'Z' = 0 - 25
        }
        return col;
    }
  }
