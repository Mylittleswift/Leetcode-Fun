/*
Given inorder and postorder traversal of a tree, construct the binary tree.
*/

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder,postorder,0,inorder.length-1, 0, postorder.length-1,map);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR, HashMap<Integer, Integer> map) {
        if(inL > inR || postL > postR) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postR]);
        int index = map.get(root.val);
        root.left = helper(inorder, postorder, inL, index - 1, postL, postL + index - inL - 1, map);
        root.right = helper(inorder, postorder, index + 1, inR, postR - (inR - index), postR - 1, map);
        return root;
    }
}

