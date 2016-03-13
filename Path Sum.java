/**
 *Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
 *such that adding up all the values along the path equals the given sum.
 */
 
 
 //recursive solution
 public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && (root.left == null && root.right == null)) {
            return true;     
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        
    }
}

 //use Queue
 public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> values = new LinkedList<Integer>();
        
        nodes.add(root);
        values.add(root.val);
        
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();
            if (curr.left == null && curr.right == null && sumValue == sum) {
                return true;
            }
            if (curr.left != null) {
                nodes.add(curr.left);
                values.add(sumValue + curr.left.val);
            }
            if (curr.right != null) {
                nodes.add(curr.right);
                values.add(sumValue + curr.right.val);
            }
        }
        return false;
    }
}


 
