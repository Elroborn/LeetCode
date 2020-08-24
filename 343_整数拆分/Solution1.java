/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-24 11:07:13
 * @FilePath: \leetcode\343_整数拆分\Solution1.java
 * @LastEditTime: 2020-08-24 11:13:44
 */
class Solution1 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            for(int j = i-1;j>=1;j--){
                dp[i] = Math.max(dp[i], Math.max(j, dp[j])*Math.max(i-j, dp[i-j]));
            }
        }
        return dp[n];

    }
}