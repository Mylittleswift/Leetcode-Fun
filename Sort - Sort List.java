/*
Sort a linked list in O(n log n) time using constant space complexity.
*/

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null){
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode head1 = walker.next;
        walker.next = null;
        return merge(sortList(head), sortList(head1));
    }
    
    
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode helper = new ListNode(0);
        helper.next = l1;
        ListNode pre = helper;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                l1 = l1.next;
            }
            else {
                ListNode next = l2.next;
                l2.next = l1;
                pre.next = l2;
                l2 = next;
            } 
            pre = pre.next;
        }
        if(l2 != null){
            pre.next = l2;
        }
        return helper.next;   
    }
}

