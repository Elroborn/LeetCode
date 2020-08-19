/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-19 10:29:49
 * @FilePath: \leetcode\647_回文子串\Solution.java
 * @LastEditTime: 2020-08-19 10:34:37
 */
class Solution {
    public int countSubstrings(String s) {
        char[] ch = s.toCharArray();
        int res = 0;
        for(int i = 0;i<ch.length ;i++){
            for(int j = i;j<ch.length;j++){
                if(is_Hui(ch,i,j)){
                    res++;
                }
            }
        }
        return res;
    }
    public boolean is_Hui(char[] ch,int i,int j){
        while(i<j){
            if(ch[i]!=ch[j]){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("aaa"));
    }
}