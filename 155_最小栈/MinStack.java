import java.util.Stack;
class MinStack {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        data.push(x);
        if(min.isEmpty() || x<=min.peek()){
            min.push(x);
        }
    }
    
    public void pop() {
        int x = data.pop();
        if(x==min.peek()){
            min.pop();
        }

    }
    
    public int top() {
        return data.peek();

    }
    
    public int getMin() {
        return min.peek();
    }
    public static void main(String[] args) {
        //Your MinStack object will be instantiated and called as such:
        MinStack obj = new MinStack();
        obj.push(0);
        obj.push(1);
        obj.push(0);
        obj.pop();
        System.out.println(obj.getMin());
        // obj.pop();
        // int param_3 = obj.top();
        // int param_4 = obj.getMin();
                
    }
}
