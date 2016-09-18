/*
Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    public String intToRoman(int num) {
         if (num < 1 && num > 3999) {
            return "";
        }
         
        String[] roman = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] digit = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder sb = new StringBuilder();
        for (int i = digit.length - 1; i >= 0; i--) {
            while (num >= digit[i]) {
                sb.append(roman[i]);
                num -= digit[i];
            }
        }
        return sb.toString();
    }
}
