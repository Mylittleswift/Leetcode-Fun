/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return toBST(nums, 0, nums.length - 1);
    }
    private TreeNode toBST(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums, lo, mid - 1);
        root.right = toBST(nums, mid + 1, hi);
        return root;
    }
}

