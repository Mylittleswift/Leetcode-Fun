/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
         
        // Step 1: count the length of the list
        int len = getLengthOfList(head);
        if (k % len == 0) {
            return head;
        }
         
        // Step 2: find the nth element from the end
        int n = k % len + 1;
        ListNode slow = head;
        ListNode fast = head;
        int count = 1;
         
        while (count < n) {
            fast = fast.next;
            count++;
        }
         
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
         
        // Step 3: rotate to the head
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
         
        return newHead;
    }
     
    private int getLengthOfList(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
         
        return len;
    }
}

