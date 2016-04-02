/*
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
You may assume each number in the sequence is unique.
Follow up:
Could you do it using only constant space complexity?
*/

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 1) {
            return true;
        }
         
        int i = -1;
        int max = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < max) {
                return false;
            }
            while (i >= 0 && num > preorder[i]) {
                max = preorder[i];
                i--;
            }
            i++;
            preorder[i] = num;
        }
        return true;
    }
}



