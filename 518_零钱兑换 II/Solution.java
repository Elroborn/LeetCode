/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-08 10:54:38
 * @FilePath: \leetcode\518_零钱兑换 II\Solution.java
 * @LastEditTime: 2020-09-08 11:11:47
 */
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin:coins){
            for(int i = 1;i<=amount;i++){
                if(i>=coin){
                    dp[i] +=dp[i-coin];
                }
            }
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(new Solution().change(5, coins));
    }
}