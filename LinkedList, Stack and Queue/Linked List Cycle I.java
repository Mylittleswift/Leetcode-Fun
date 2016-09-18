/*
Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?
*/

public class ListNode {
	int val;
	ListNode next;
	ListNode (int x) {
		val = x;
		next = null;
	}	

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
}

