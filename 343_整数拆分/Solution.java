/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-30 10:52:10
 * @FilePath: \leetcode\343_整数拆分\Solution.java
 * @LastEditTime: 2020-07-30 10:58:57
 */ 
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1] ;// dp[i] 代表对 i进行划分的最大结果
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            int t = 0;
            for(int j = 1;j<i;j++){ // i可以看作 j和i-j的和
                //因为至少划分两个数字，所以j不能是0或者i
                t = Math.max(t,Math.max(j*(i-j), j*dp[i-j]));
            }
            dp[i] = t;
        }
        return dp[n];
    }
}