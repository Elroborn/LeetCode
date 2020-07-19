/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-16 20:42:57
 * @FilePath: \leetcode\392_判断子序列\Solution.java
 * @LastEditTime: 2020-07-16 20:47:44
 */ 
class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for(char c : s.toCharArray()){
            // s是否为t的子串，看s中每个字符在t中位置依次递增
            index = t.indexOf(c, index+1);
            if(index == -1){
                // 未找到
                return false;
            }
        }
        return true;
    }
}