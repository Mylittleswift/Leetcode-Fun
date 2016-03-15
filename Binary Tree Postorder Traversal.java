/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
*/

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        TreeNode prev = null;
        while(!stack.empty()) {
            TreeNode curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if(curr.left != null) {
                    stack.push(curr.left);
                } else if(curr.right != null){
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    result.add(curr.val);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    result.add(curr.val);
                }
            }else if (curr.right == prev) {
                stack.pop();
                result.add(curr.val);
            }
            prev = curr;
        }
        return result;
    }
}

