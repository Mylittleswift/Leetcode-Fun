/*
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  
   
*/

//recursive
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
         
        return upsideDownBinaryTreeHelper(root, null);
    }
     
    private TreeNode upsideDownBinaryTreeHelper(TreeNode root, TreeNode parent) {
        if (root == null) {
            return parent;
        }
         
        TreeNode newNode = upsideDownBinaryTreeHelper(root.left, root);
         
        root.left = parent == null ? null : parent.right;
        root.right = parent;
         
        return newNode;
    }
}


//iterative
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
         
        TreeNode parent = null;
        TreeNode parentRightChild = null;
        TreeNode p = root;
         
        while (p != null) {
            TreeNode next = p.left;
            p.left = parentRightChild;
            parentRightChild = p.right;
             
            p.right = parent;
             
            parent = p;
            p = next;
        }
         
        return parent;
    }
}


