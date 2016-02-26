/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Write a function to determine if a number is strobogrammatic. The number is represented as a string.
For example, the numbers "69", "88", and "818" are all strobogrammatic.
Understand the problem:
The key of the problem is to understand what is called "strobogrammatic number". As defined, the number 0, 1 and 8 are strobogrammatic. However, 6 and 9 are kind of special. E.g. 
6 0 0 9, return True
66 000 99, return True;
6969 return true; 
6996, return true;
*/


//solution1
public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
         
        int lo = 0;
        int hi = num.length() - 1;
         
        while (lo <= hi) {
            if (num.charAt(lo) == num.charAt(hi)) {
                if (isStrobo(num.charAt(lo))) {
                    hi--;
                    lo++;
                } else {
                    return false;
                }
            } else {
                if ((num.charAt(lo) == '6' && num.charAt(hi) == '9') ||
                    (num.charAt(lo) == '9' && num.charAt(hi) == '6')) {
                    hi--;
                    lo++;
                } else {
                    return false;
                }
            }
        }
         
        return true;
    }
     
    private boolean isStrobo(Character num) {
        return num == '0' || num == '1' || num == '8';
    }
}


//solution2
public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) {
            return true;
        }
         
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
         
        int lo = 0;
        int hi = num.length() - 1;
         
        while (lo <= hi) {
            char c1 = num.charAt(lo);
            char c2 = num.charAt(hi);
             
            if (!map.containsKey(c1) || map.get(c1) != c2) {
                return false;
            }
             
            lo++;
            hi--;
        }
         
        return true;
    }
}



