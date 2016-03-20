/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null)
            return result;
            
        findPaths(root, result, root.val + "");
        return result;
    }
    
    private void findPaths(TreeNode root, List<String> result, String cur) {
        if (root.left == null && root.right == null) {
            result.add(cur);
        }
        if (root.left != null) {
            findPaths(root.left, result, cur + "->" + root.left.val);
        }
        if (root.right != null) {
            findPaths(root.right, result, cur + "->" + root.right.val);
        }
    }
}



