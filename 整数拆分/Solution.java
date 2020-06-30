/*
 * @Descripttion: 题目：给定一个整数n，输出这个整数拆分的可能总数
 * @Author: coderwangson
 * @Date: 2020-06-30 10:47:21
 * @FilePath: \leetcode\整数拆分\Solution.java
 * @LastEditTime: 2020-06-30 10:50:29
 */ 
class Solution{
    /**
     * @Descripttion: 对n进行不超过m的划分
     * @param {type} 
     * @return: 
     */
    public int partion(int n,int m){
        if(n==1 || m==1){
            return 1;// base case
        }
        if(n<m){
            return partion(n, n); //规模缩小
        }else if(n==m){
            return 1+partion(n, n-1);
        }else{
            //m<n
            return partion(n-m, m) + partion(n, m-1);
        }
        
    }
    public static void main(String[] args) {
        System.out.println(new Solution().partion(6, 6));
    }
}