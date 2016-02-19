 
 
 //Solution 1 - Iterative
 
 public ListNode reverseList(ListNode head) {
    if(head==null || head.next == null) 
        return head;
 
    ListNode p1 = head;
    ListNode p2 = head.next;
 
    head.next = null;
    while(p1!= null && p2!= null){
        ListNode t = p2.next;
        p2.next = p1;
        p1 = p2;
        if (t!=null){
            p2 = t;
        }else{
            break;
        }
    }
    return p2;
  }


//Solution 2 - Recursive
public ListNode reverseList(ListNode head) {
    if(head==null || head.next == null)
        return head;

    ListNode second = head.next;
    head.next = null;
    ListNode rest = reverseList(second);
    second.next = head;
 
    return rest;
  }





 
 
