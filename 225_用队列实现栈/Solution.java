import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue;
    Queue<Integer> tmp;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
        tmp = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        while(!queue.isEmpty()){
            tmp.add(queue.poll());
        }
        queue.add(x);
        while(!tmp.isEmpty()){
            queue.add(tmp.poll());
        }

    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */