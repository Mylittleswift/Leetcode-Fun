/**
 *Given a binary tree, find its maximum depth.
 *The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *Travase the left node and right node from root, find the maxDepth equals to left or right.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public int maxDepth(TreeNode root) {
        int left=0;
        int right=0;
        
        if(root == null) {return 0;}
    else{
      left = maxDepth(root.left)+1;
      right = maxDepth(root.right)+1;
    }
    return left>right?left:right;
  }
}

