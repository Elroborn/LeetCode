/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-30 11:20:49
 * @FilePath: \leetcode\279_完全平方数\Solution1.java
 * @LastEditTime: 2020-07-30 14:31:37
 */ 
class Solution1 {
    public int numSquares(int n) {
        //比如13 可以看作减的过程，先减 1 4 9 得到一波12 9 4 ，然后同理，最后其实就是算当13减到0 的时候最短路径
        // 可以bfs，用一个set做减枝，比如上面13的4已经算过了，那么12可能还会得到一个4，就不用再算了
        // 按照这个思路，可以考虑dp，dp[i] 就代表i的最短，dp[i] = min(dp[i- 1,4,9] +1) dp[0] = 0 dp[1] = 1
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            int t = Integer.MAX_VALUE;
            for(int j = 1;j*j<=i;j++){
                t = Math.min(t,dp[i-j*j] + 1); //+1 就是对应的j那个数字
            }
            dp[i] = t;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(new Solution1().numSquares(13));
    }
}