class Solution {
    // dp[n] = min(dp[n-coin]+1)  coin in conis
    // 比如你要求amount为11，则求出来amount=10 的再加入一枚1即可或者amount 9的再加入一枚2即可，所以有最小独立子问题
    // 确定状态，因为amount是变量，所以把amout作为状态 即amount为n时的最小为dp[n]
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            int tmp = Integer.MAX_VALUE;
            // 确定dp[i]
            for(int coin:coins){
                if(i-coin>=0 && dp[i-coin]!=-1){
                    tmp = Math.min(tmp, dp[i-coin]+1);
                }
            }
            if(tmp==Integer.MAX_VALUE){
                dp[i] = -1;
            }else{
                dp[i] = tmp;
            }
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(new Solution().coinChange(coins, 3));
    }
}