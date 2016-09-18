/*
Given a singly linked list, determine if it is a palindrome.
Follow up:
Could you do it in O(n) time and O(1) space?
*/

//We can create a new list in reversed order and then compare each node. The time and space are O(n).
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) 
            return true;
        ListNode p = head;
        ListNode prev = new ListNode(head.val);
    
        //reversed list
        while (p.next != null) {
            ListNode temp = new ListNode(p.next.val);
            temp.next = prev;
            prev = temp;
            p = p.next;
        }
        ListNode p1 = head;
        ListNode p2 = prev;
        while (p1 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}


//We can use a fast and slow pointer to get the center of the list, 
// then reverse the second list and compare two sublists. 
//The time is O(n) and space is O(1).
public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow);
        while (newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
        
    }
    
    private ListNode reverse(ListNode cur) {
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

