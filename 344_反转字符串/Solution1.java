/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-08 08:50:22
 * @FilePath: \leetcode\344_反转字符串\Solution1.java
 * @LastEditTime: 2020-10-08 08:51:25
 */
class Solution {
    public void reverseString(char[] s) {
        int i = 0,j = s.length -1;
        char t;
        while(i<j){
            t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }
}