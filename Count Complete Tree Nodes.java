/*
Given a complete binary tree, count the number of nodes.
Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible.
It can have between 1 and 2h nodes inclusive at the last level h.
*/

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);
         
        if (leftHeight == rightHeight) {
            return (2 << (leftHeight - 1)) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
     
    private int findLeftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 1;
        while (root.left != null) {
            height++;
            root = root.left;
        }
        return height;
    }
     
    private int findRightHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 1;
        while (root.right != null) {
            height++;
            root = root.right;
        }
        return height;
    }
}


