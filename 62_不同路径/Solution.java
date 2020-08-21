/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-21 10:47:13
 * @FilePath: \leetcode\62_不同路径\Solution.java
 * @LastEditTime: 2020-08-21 10:56:44
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(j==0 && i==0){
                    dp[j] = 1;
                }else if(i==0){
                    dp[j]=dp[j-1]; // 没有上
                }else if(j==0){
                    dp[j]=dp[j]; // 没有左
                }else{
                    dp[j] = dp[j]+dp[j-1]; // =号右边dp[j]代表上 dp[j-1]代表左
                }
            }
        }
        return dp[n-1];

    }
}