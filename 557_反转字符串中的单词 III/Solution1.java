/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-30 10:07:58
 * @FilePath: \leetcode\557_反转字符串中的单词 III\Solution1.java
 * @LastEditTime: 2020-08-30 10:26:25
 */
class Solution1 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder t = new StringBuilder();
        int i = 0;
        while(i<s.length()){
            t = new StringBuilder();
            while(i<s.length() && s.charAt(i)!=' '){
                t.append(s.charAt(i));
                i++;
            }
            if(t.length()>0){
                sb.append(t.reverse());
            }
            while(i<s.length() && s.charAt(i)==' '){
                i++;
            }
            if(i<s.length()){
                sb.append(' ');
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest  ";
        System.out.println(new Solution1().reverseWords(s)+"||");
    }
}