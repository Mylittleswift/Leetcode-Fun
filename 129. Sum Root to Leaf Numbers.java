/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
*/

public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, 0, 0);
    }
 
    public int dfs(TreeNode node, int num, int sum){
        if(node == null) return sum;
        num = num*10 + node.val;
        // leaf
        if(node.left == null && node.right == null) {
            sum += num;
            return sum;
        }
 
        // left subtree + right subtree
        sum = dfs(node.left, num, sum) + dfs(node.right, num, sum);
        return sum;
    }
}

