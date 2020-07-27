import java.util.LinkedList;
import java.util.Queue;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-27 10:30:52
 * @FilePath: \leetcode\1091_二进制矩阵中的最短路径\Solution.java
 * @LastEditTime: 2020-07-27 11:00:18
 */ 
class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
    int rows,cols;
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid==null || grid.length ==0 || grid[0].length==0 || grid[0][0]!=0){
            return -1;
        }
        rows = grid.length;
        cols = grid[0].length;
        int[][] flag = new int[rows][cols]; // 其实不用flag也可，直接把grid对应位置赋值为1
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int ans = 0;
        while(!queue.isEmpty()){
            ans++;
            int layers = queue.size();
            for(int i = 0;i<layers;i++){ //每次遍历一层
                int[] node = queue.poll();
                if(node[0]==rows-1 && node[1]==cols-1){
                    return ans;
                }
                for(int[]d :dirs){
                    int new_i = node[0] + d[0];
                    int new_j = node[1] + d[1];
                    if(new_i>=0 && new_i<rows && new_j >=0 && new_j<cols && grid[new_i][new_j]==0 && flag[new_i][new_j]==0){
                        queue.add(new int[]{new_i,new_j});
                        flag[new_i][new_j] =1 ;
                    }
                }
            }
            
   
        }
        return -1;

    }

}