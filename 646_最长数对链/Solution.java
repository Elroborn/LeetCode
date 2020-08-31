/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-30 10:55:34
 * @FilePath: \leetcode\646_最长数对链\Solution.java
 * @LastEditTime: 2020-08-30 16:57:44
 */
import java.util.Arrays;
class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs.length==0){
            return 0;
        }
        Arrays.sort(pairs, (a, b) -> (a[0] == b[0]?(a[1] - b[1]):(a[0] - b[0])));
        int[] dp = new int[pairs.length];
        dp[0] =1;
        int res = dp[0];
        for(int i = 1;i<pairs.length;i++){
            dp[i] =1;
            for(int j = 0;j<i;j++){
                if(pairs[j][1]<pairs[i][0] || pairs[i][1]<pairs[j][0]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[][]pairs = {{2,1},{1,2},{1,4},{1,3}};
        System.out.println(new Solution().findLongestChain(pairs));
    }
}