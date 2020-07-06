/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-06 10:29:14
 * @FilePath: \leetcode\63_不同路径 II\Solution.java
 * @LastEditTime: 2020-07-06 10:37:14
 */ 
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0] ==0){
            dp[0][0] = 1;
        }else{
            return 0;
        }
        for(int i = 0;i<obstacleGrid.length;i++){
            for(int j = 0;j<obstacleGrid[i].length;j++){
                if(i==0 && j==0){
                    continue;
                }
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0;
                }else{
                    int left = (j-1>=0)?dp[i][j-1]:0;
                    int up = (i-1>=0)?dp[i-1][j]:0;
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}