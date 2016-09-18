/*
sort a linked list using insertion sort.
*/

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
         
        ListNode helper = new ListNode(Integer.MIN_VALUE);
        ListNode prev = helper;
        ListNode curr = head;
         
        while (curr != null) {
            prev = helper;
            ListNode next = curr.next;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            curr.next = prev.next; 
            prev.next = curr;
            curr = next;
        }
        return helper.next;
    }
}

