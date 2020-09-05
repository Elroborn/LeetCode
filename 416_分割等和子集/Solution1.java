import java.util.Arrays;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-03 11:28:21
 * @FilePath: \leetcode\416_分割等和子集\Solution1.java
 * @LastEditTime: 2020-09-05 11:19:10
 */
class Solution1 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n:nums){
            sum+=n;
        }
        if(sum%2!=0){
            return false;
        }else{
            sum/=2;
        }
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        for(int i=0;i<=nums.length;i++){
            dp[i][0] = true;
        }
        for(int i = 1;i<=nums.length;i++){
            for(int j = 1;j<=sum;j++){
                if(nums[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j]  = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum];
    }
}