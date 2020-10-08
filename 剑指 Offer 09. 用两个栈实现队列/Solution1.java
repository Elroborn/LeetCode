import java.util.Stack;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-08 09:42:09
 * @FilePath: \leetcode\剑指 Offer 09. 用两个栈实现队列\Solution1.java
 * @LastEditTime: 2020-10-08 09:45:34
 */
class CQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void appendTail(int value) {
        s1.push(value);
    }
    
    public int deleteHead() {
        if(!s2.isEmpty()){
            return s2.pop();
        }
        if(s1.isEmpty()){
            return -1;
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */