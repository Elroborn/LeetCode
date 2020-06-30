import java.util.Stack;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-06-30 08:59:35
 * @FilePath: \leetcode\剑指 Offer 09. 用两个栈实现队列\Solution.java
 * @LastEditTime: 2020-06-30 09:03:45
 */ 
class CQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void appendTail(int value) {
        s1.add(value);
    }
    
    public int deleteHead() {
        if(s1.isEmpty() && s2.isEmpty()){
            return -1;
        }
        if(!s2.isEmpty()){
            return s2.pop();
        }else{
            while(!s1.isEmpty()){
                s2.add(s1.pop());
            }
            return s2.pop();
        }
        

    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */