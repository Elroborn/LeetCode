import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-14 09:58:02
 * @FilePath: \leetcode\20_有效的括号\Solution1.java
 * @LastEditTime: 2020-08-14 10:18:08
 */
class Solution1 {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        if(s.length() ==0){
            return true;
        }
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                deque.push(s.charAt(i));
            }else{
                if(deque.peek()==null){
                    return false;
                }else{
                    char c = deque.pop();
                    if(c!=getRight(s.charAt(i))){
                        return false;
                    }
                }
            }
        }
        return deque.isEmpty();

    }
    public char getRight(char c){
        if(c==')'){
            return '(';
        }
        if(c=='}'){
            return '{';
        }
        if(c==']'){
            return '[';
        }
        return ' ';
    }
    public static void main(String[] args) {
        // String s = "([)]";
        // System.out.println(new Solution1().isValid(s));
        Deque<String> deque = new ArrayDeque<>();
    }
}