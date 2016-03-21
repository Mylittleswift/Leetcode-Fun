 /**
  *given a positive integer, return its corresponding column title as appear in an Excel sheet.
  */
  
  //Soluion1
  public class Solution {
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        return convertToTitle((n - 1) / 26) + (char)((n - 1) % 26 + 'A');
    }
  }
  
  
  //Solution2
  
  public class Solution {
    public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int d = n % 26;
            n /= 26;
            if (d == 0) {
                sb.append('Z');
                n--;
            } else {
                sb.append((char)('A' + d - 1));
            }
        }
        return sb.reverse().toString();
    }
 }
 
 
