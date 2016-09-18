/*
  Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 (ie, from left to right, level by level from leaf to root).
 For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/



public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ressult = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) 
            return result;
            
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> curLevel = new ArrayList<Integer>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(curLevel);
        }
        Collections.reverse(result);
        return result;
    }
}

