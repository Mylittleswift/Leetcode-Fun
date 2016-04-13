/** 
*Write a program to find the node at which the intersection of two singly linked lists begins.
*If the two linked lists have no intersection at all, return null.
*The linked lists must retain their original structure after the function returns.
*You may assume there are no cycles anywhere in the entire linked structure.
*Your code should preferably run in O(n) time and use only O(1) memory.
*/


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = (curA == null? headB:curA.next);
            curB = (curB == null? headA:curB.next);
        }
        return curA;
    }
}

