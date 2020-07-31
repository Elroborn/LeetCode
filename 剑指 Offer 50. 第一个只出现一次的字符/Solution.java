/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-31 10:32:18
 * @FilePath: \leetcode\剑指 Offer 50. 第一个只出现一次的字符\Solution.java
 * @LastEditTime: 2020-07-31 10:36:16
 */ 
class Solution {
    public char firstUniqChar(String s) {
        int[] charNum = new int[26];
        for(char c:s.toCharArray()){
            charNum[c-'a']++;
        }
        for(char c:s.toCharArray()){
            if(charNum[c-'a']==1){
                return c;
            }
        }
        return ' ';
    }
    public static void main(String[] args) {
        int a = 'A';
        System.out.println(a);
    }
}