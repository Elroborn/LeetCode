/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-16 16:22:06
 * @FilePath: \leetcode\剑指 Offer 14- I. 剪绳子\Solution.java
 * @LastEditTime: 2020-10-16 16:34:25
 */
class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            // 计算dp[i]    每个又可以分为多个选择 参看剑指offer，这个每次的选择也是动态和贪心的区别
            for(int j = 1;j<i;j++){
                dp[i] = Math.max(j*(i-j),Math.max(dp[i], j*dp[i-j])); // 因为之前切割的时候不能完整，比如dp[2] = 1但是如果对于4而言，可以切割完整两个2，所以增加一个i*(i-j)
            }
        }
        return dp[n];
    }
}