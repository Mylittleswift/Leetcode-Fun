/*
Follow up for problem "Populating Next Right Pointers in Each Node".
What if the given tree could be any binary tree? Would your previous solution still work?
Note:
You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
         
        TreeLinkNode curr = root;
        TreeLinkNode dummyNode = new TreeLinkNode(0);
        TreeLinkNode pre = dummyNode;
         
        while (curr != null) {
            TreeLinkNode tmp = curr;
            while (tmp != null) {
                if (tmp.left != null) {
                    pre.next = tmp.left;
                    pre = pre.next;
                }
                 
                if (tmp.right != null) {
                    pre.next = tmp.right;
                    pre = pre.next;
                }
                 
                tmp = tmp.next;
                 
                if (tmp == null) {
                    curr = dummyNode.next;
                    pre = dummyNode;
                    dummyNode.next = null;
                }
            }
        }
    }
}


