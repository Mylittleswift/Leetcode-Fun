/*
sort a linked list using insertion sort.
*/

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
         
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode prev = newHead;
        ListNode curr = head;
         
        while (curr != null) {
            prev = newHead;
            ListNode next = curr.next;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        return newHead.next;
    }
}

