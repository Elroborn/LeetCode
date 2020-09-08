import java.util.Arrays;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-02 12:50:39
 * @FilePath: \leetcode\322_零钱兑换\Solution1.java
 * @LastEditTime: 2020-09-08 10:54:05
 */ 
class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int[] dp =new int[amount+1];
        Arrays.fill(dp, amount+1); //因为凑够amout最多amout个硬币即可 amout+1 代表不可达
        dp[0] = 0; //如果刚好一个硬币那么dp[i-coins[j]] 刚好是0 ，所以虽然0是不可达，但是为了后面计算方便置为 0 
        for(int i = 1;i<=amount;i++){
            for(int j = 0;j<coins.length;j++){
                if(i >=coins[j]){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] +1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}