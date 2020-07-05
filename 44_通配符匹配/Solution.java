/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-05 10:28:26
 * @FilePath: \leetcode\44_通配符匹配\Solution.java
 * @LastEditTime: 2020-07-05 10:29:12
 */ 
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1]; // 长度为i的s和长度为j的p匹配情况，注意是长度
        dp[0][0] = true;
        for(int i = 1;i<=m;i++){
            dp[i][0] = false; // 0就是长度为0 空串 
        }
        for(int j =1;j<=n;j++){
            if(p.charAt(j-1)=='*'){ // p[i-1] 代表长度为i的p，因为下标从0开始
                dp[0][j] = true;
            }else{
                break; // 都为false（默认）
            }
        }
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(p.charAt(j-1)!='*'){
                    // i j 代表长度为i和j 所以s.charAt(i-1) 因为s下标是从0开始其就相当于s_i
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) =='?');
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}