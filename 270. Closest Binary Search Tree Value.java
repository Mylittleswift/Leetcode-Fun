/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
*/

public class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            throw new NullPointerException("Tree must be non-empty");
        }
         
        int result = 0;
        double gap = Double.MAX_VALUE;
         
        while (root != null) {
            if (root.val == target) {
                return root.val;
            }
             
            double dist = Math.abs(root.val - target);
            if (dist < gap) {
                result = root.val;
                gap = dist;
            }
             
            if (target > root.val) {
                root = root.right;
            } else if (target < root.val) {
                root = root.left;
            }
        }
        return result;
    }
}


