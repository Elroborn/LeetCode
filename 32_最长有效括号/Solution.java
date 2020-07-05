/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-04 10:13:46
 * @FilePath: \leetcode\32_最长有效括号\Solution.java
 * @LastEditTime: 2020-07-04 10:39:29
 */ 
import java.util.Stack;
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        // stack.push(-1);
        char[] ch = s.toCharArray();
        for(int i =0;i<ch.length;i++){
            if(ch[i]=='('){
                stack.push(i);
            }else{
                stack.pop(); //说明-1弹出，说明这个）没有被匹配
                if(stack.isEmpty()){
                    stack.push(i); // 之所以将右括号下标push，为了将来计算距离
                }else{
                    stack.pop();
                    res = Math.max(res,i - stack.peek());
                }
            }
        }
        return res;
    }
}