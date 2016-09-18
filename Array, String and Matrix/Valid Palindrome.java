/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
*/

//solution 1
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}


//solution 2: two pointers
public class Solution {
	public class ValidPalindrome {
		public static boolean isValidPalindrome(String s){
			if(s==null||s.length()==0) return false;
	 
			s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
			System.out.println(s);
	 
			for(int i = 0; i < s.length() ; i++){
				if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
					return false;
				}
			}
	 
			return true;
		}
	}
}


