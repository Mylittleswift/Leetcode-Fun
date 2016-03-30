/**
 *Implement the following operations of a queue using stacks.
 *push(x) -- Push element x to the back of queue.
 *pop() -- Removes the element from in front of queue.
 *peek() -- Get the front element.*
 *empty() -- Return whether the queue is empty.
 */
 
 class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
     
    public MyQueue() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }
 
    // Removes the element from in front of queue.
    public void pop() {
        if (!stack2.isEmpty()) {
            stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack2.pop();
        }
    }
 
    // Get the front element.
    public int peek() {
        int ret = 0;
        if (!stack2.isEmpty()) {
            ret = stack2.peek();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            ret = stack2.peek();
        }
         
        return ret;
    }
 
    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
        
    }
}


