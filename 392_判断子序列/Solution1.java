/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-27 10:06:25
 * @FilePath: \leetcode\392_判断子序列\Solution1.java
 * @LastEditTime: 2020-07-27 10:09:00
 */ 
class Solution1 {
    public boolean isSubsequence(String s, String t) {
        int i = 0,j = 0;
        while(i<s.length() && j< t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i == s.length();

    }
}