/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-01 11:25:07
 * @FilePath: \leetcode\633_平方数之和\Solution.java
 * @LastEditTime: 2020-07-01 11:35:04
 */ 
class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        // i^2 + j^2 接近c，且i从0开始，所以j从sqrt c即可
        int j = (int) Math.sqrt(c);
        int t = 0;
        while(i<=j){
            t = i*i +j*j;
            if(t==c){
                return true;
            }else if(t<c){
                i++;
            }else{
                j--;
            }
        }
        return false;

    }
}