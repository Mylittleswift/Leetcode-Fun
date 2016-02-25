/**
*Implement the following operations of a stack using queues.
*push(x) -- Push element x onto stack.
*pop() -- Removes the element on top of the stack.
*top() -- Get the top element.
*empty() -- Return whether the stack is empty.
*/

class MyStack {
    private LinkedList<Integer> queue = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
        
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!empty()) {
            queue.pop();
        }
        
    }

    // Get the top element.
    public int top() {
        if (!empty()) {
            return queue.peek();
        }
        return -1;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
        
    }
}

