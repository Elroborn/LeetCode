/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-26 10:16:28
 * @FilePath: \leetcode\329_矩阵中的最长递增路径\Solution.java
 * @LastEditTime: 2020-07-26 10:27:00
 */ 
class Solution {
    private int cols,rows;
    private int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length ==0 || matrix[0].length ==0){
            return 0;
        }
        rows = matrix.length;
        cols = matrix[0].length;
        int[][] memory = new int[rows][cols];
        int ans = 0;
        for(int i=0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                ans = Math.max(ans, dfs(i,j,memory,matrix));
            }
        }
        return ans;
    }
    private int dfs(int i,int j,int[][] memory,int[][] matrix){
        if(memory[i][j]!=0){
            return memory[i][j];
        }
        memory[i][j]++;//本身节点
        for(int[] d: dirs){ //四个方向找最大
            int new_i = i + d[0];
            int new_j = j + d[1];
            if(new_i>=0 && new_i<rows && new_j>=0 && new_j<cols && matrix[new_i][new_j]> matrix[i][j]){
                memory[i][j] = Math.max(memory[i][j], dfs(new_i, new_j, memory, matrix)+1); //+1 就是加上i j这个位置的节点
            }
        }
        return memory[i][j];
    }
}