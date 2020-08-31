/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-06-10 10:28:38
 * @FilePath: \leetcode\300_最长上升子序列\Solution1.java
 * @LastEditTime: 2020-08-30 10:38:37
 */
class Solution1 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = dp[0];
        for(int i = 1;i<nums.length;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}