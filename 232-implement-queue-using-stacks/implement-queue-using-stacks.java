import java.util.Stack;

class MyQueue {
    // stack acts as the input container, stack1 acts as the output container
    private Stack<Integer> stack;
    private Stack<Integer> stack1;

    public MyQueue() {
        this.stack = new Stack<>();
        this.stack1 = new Stack<>();
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x); // O(1)
    }
    
    // Removes the element from in front of queue and returns it.
    public int pop() {
        shiftStacks();
        return stack1.pop(); // Amortized O(1)
    }
    
    // Get the front element.
    public int peek() {
        shiftStacks();
        return stack1.peek(); // Amortized O(1)
    }
    
    // Returns whether the queue is empty.
    public boolean empty() {
        // The queue is only truly empty if BOTH stacks have no elements
        return stack.isEmpty() && stack1.isEmpty();
    }

    // Helper method to move elements only when the output stack is empty
    private void shiftStacks() {
        if (stack1.isEmpty()) {
            while (!stack.isEmpty()) {
                stack1.push(stack.pop());
            }
        }
    }
}
