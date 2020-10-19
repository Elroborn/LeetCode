import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-19 08:53:36
 * @FilePath: \leetcode\844_比较含退格的字符串\Solution.java
 * @LastEditTime: 2020-10-19 08:58:43
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Deque<Character> s1 = new ArrayDeque<>();
        Deque<Character> s2 = new ArrayDeque<>();
        for(char c:S.toCharArray()){
            if(c!='#'){
                s1.push(c);
            }else{
                if(!s1.isEmpty()){
                    s1.pop();
                }
            }
        }
        for(char c:T.toCharArray()){
            if(c!='#'){
                s2.push(c);
            }else{
                if(!s2.isEmpty()){
                    s2.pop();
                }
            }
        }
        return s1.toString().equals(s2.toString());
    }
}