/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-01 10:01:29
 * @FilePath: \leetcode\718_最长重复子数组\Solution.java
 * @LastEditTime: 2020-07-01 10:54:22
 */ 
class Solution {
    public int findLength1(int[] A, int[] B) {
        int res = 0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int tmp_len = 0;
                while(i+tmp_len<A.length && j+tmp_len<B.length && A[i+tmp_len]==B[j+tmp_len]){
                    tmp_len++;
                }
                res = Math.max(res,tmp_len);
            }
        }
        return res;
    }
    public int findLength(int[] A, int[] B) {
        int res = 0;
        int[][] dp = new int[A.length+1][B.length+1]; //dp[i][j] 代表A[i:] 和B[j:] 最长，dp[i][j] = A[i]==B[j]?dp[i+1][j+1] +1:0;
        for(int i=A.length-1;i>=0;i--){
            for(int j = B.length-1;j>=0;j--){
                dp[i][j] = A[i]==B[j]?dp[i+1][j+1] +1:0;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}