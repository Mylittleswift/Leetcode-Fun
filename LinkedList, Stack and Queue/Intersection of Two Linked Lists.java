/** 
*Write a program to find the node at which the intersection of two singly linked lists begins.
*If the two linked lists have no intersection at all, return null.
*The linked lists must retain their original structure after the function returns.
*You may assume there are no cycles anywhere in the entire linked structure.
*Your code should preferably run in O(n) time and use only O(1) memory.
*/
public class ListNode {
	int val;
	ListNode next;
	ListNode (int x) {
		val = x;
		next = null;
	}
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
        	if (curA == null) {
        		curA = headB;
        	} else {
        		curA = curA.next;
        	}
        	if (curB == null) {
        		curB = headA;
        	} else {
        		curB = curB.next;
        	}
        }
        return curA; // or curB
    }
}

