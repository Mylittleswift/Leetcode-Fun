/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
import java.util.Stack;

class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
	}
 
	public void pop() {
	    if (stack.peek() == min) {
	        stack.pop();
	        min = stack.peek();
	        stack.pop();
	    } else {
	        stack.pop();
	    }
	    if (stack.empty()) {
	        min = Integer.MAX_VALUE;
	    }
	}
	
 
	public int top() {
	    return stack.peek();
	}
 
	public int getMin() {
	    return min;
	}
}

