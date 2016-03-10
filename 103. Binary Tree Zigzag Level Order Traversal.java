/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        zigzagLevelOrder(root, result, 1);
        return result;
    }
     
    private void zigzagLevelOrder(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) return;
         
        if (result.size() < level) {
            ArrayList<Integer> levelList = new ArrayList<Integer>();
            if ((level % 2) == 1) {
                levelList.add(root.val);
            } else {
                levelList.add(0, root.val);
            }
            result.add(levelList);
        } else {
            if ((level % 2) == 1) {
                result.get(level - 1).add(root.val);
            } else {
                result.get(level - 1).add(0, root.val);
            }
        }
        zigzagLevelOrder(root.left, result, level + 1);
        zigzagLevelOrder(root.right, result, level + 1);
    }
}

