import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-07 10:58:31
 * @FilePath: \leetcode\417_太平洋大西洋水流问题\Solution.java
 * @LastEditTime: 2020-08-07 12:43:23
 */
class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<matrix.length;i++){
            for(int j= 0;j<matrix[i].length;j++){
                boolean[] is_ok = {false,false};
                boolean[][] vis = new boolean[matrix.length][matrix[0].length];
                dfs(matrix,i,j,is_ok,vis);
                if(is_ok[0] && is_ok[1]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    public void dfs(int[][] matrix,int i,int j,boolean[] is_ok,boolean[][] vis){
        vis[i][j] = true;
        for(int[] dir:dirs){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if(new_i<0 ||new_j<0){
                is_ok[0] =true;
            }
            if(new_i>=matrix.length || new_j>=matrix[0].length){
                is_ok[1] =true;
            }
            if(new_i>=0 && new_i<matrix.length && new_j>=0 && new_j<matrix[i].length && matrix[new_i][new_j]<=matrix[i][j] && !vis[new_i][new_j]){
                dfs(matrix, new_i, new_j, is_ok, vis);
            }
        }

    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        new Solution().pacificAtlantic(matrix);
    }
}