/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
         
        Arrays.sort(strs, new StringComparator());
         
        StringBuffer sb = new StringBuffer();
         
        for (String str : strs) {
            sb.append(str);
        }
         
        if (sb.charAt(0) == '0') {
            return "0";
        }
         
        return sb.toString();
    }
     
    public class StringComparator implements Comparator<String> {
        @Override
        public int compare (String str1, String str2) {
            String ab = str1 + str2;
            String ba = str2 + str1;
            return ba.compareTo(ab);
        }
    }
}

