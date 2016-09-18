/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            //map inorder index for each node to map index faster
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    private TreeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> map) {
        if(preL > preR || inL > inR) {
            return null;
        }
        //according to the preorder, the first must be the root for current sub tree
        TreeNode root = new TreeNode(preorder[preL]); 
        //use hashmap to find index instead of linear search
        int index = map.get(root.val); 
        root.left = helper(preorder, preL + 1, index - inL + preL, inorder, inL, index - 1, map);
        root.right = helper(preorder, preL + index - inL + 1, preR, inorder, index + 1, inR, map);
        return root;
    }
}

