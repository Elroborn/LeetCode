/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-21 10:38:55
 * @FilePath: \leetcode\64_最小路径和\Solution.java
 * @LastEditTime: 2020-08-21 10:43:48
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        res[0][0] = grid[0][0];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                int t1 = Integer.MAX_VALUE;
                int t2 = Integer.MAX_VALUE;
                if(i-1>=0){
                    t1 = res[i-1][j];
                }
                if(j-1>=0){
                    t2 = res[i][j-1];
                }
                if(i-1<0 && j-1<0){
                    res[i][j] = grid[i][j];
                }else{
                    res[i][j] = grid[i][j]+ Math.min(t1, t2);
                }
            }
        }
        return res[grid.length-1][grid[0].length-1];
    }
}