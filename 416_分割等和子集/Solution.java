/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-09 14:39:44
 * @FilePath: \leetcode\416_分割等和子集\Solution.java
 * @LastEditTime: 2020-08-09 16:29:01
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0){ // 奇数不能均分
            return false;
        }
        sum = sum/2; // 问题转化为是否能用nums里面的所有数字将sum/2 装满 变为完全背包问题
        boolean[][] dp = new boolean[nums.length+1][sum+1]; // dp[i][j] 代表前i个物品是否能够塞满容量为j的背包
        // 初始状态dp[0][..] 代表没有物品，所以肯定塞不满，为false
        // dp[...][0] 代表背包为空，肯定能塞满
        for(int i = 0;i<=nums.length;i++){
            dp[i][0] = true;
        }
        // 状态转移
        // 注意外面循环是物品，这个要和硬币那个问题区分，因为硬币问题每个硬币可以有多个，所以硬币可以放内层循环  
        for(int i = 1;i<=nums.length;i++){ //注意i从1开始，代表有一个物品，其重量应该是nums[i-1]
            for(int j=1;j<=sum;j++){
                if(nums[i-1] >j){ //装不下
                    dp[i][j] = dp[i- 1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]]; // 装入背包或者不装入
                }
            }
        }
        return dp[nums.length][sum];

    }
}