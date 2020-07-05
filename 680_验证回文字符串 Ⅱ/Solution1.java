/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-04 11:02:41
 * @FilePath: \leetcode\680_验证回文字符串 Ⅱ\Solution1.java
 * @LastEditTime: 2020-07-04 11:07:38
 */ 
class Solution1 {
    public boolean validPalindrome(String s) {
        int i = 0,j = s.length()-1;
        while(i<j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{ //一次删除机会
                return is_palin(s, i+1, j) || is_palin(s, i, j-1);
            }
        }
        return true;
    }
    public boolean is_palin(String s,int i,int j){
        while(i<j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}