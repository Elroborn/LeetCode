/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-01 16:39:29
 * @FilePath: \leetcode\695_岛屿的最大面积\Solution.java
 * @LastEditTime: 2020-08-01 16:46:37
 */ 
class Solution {
    private int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;
        if(grid==null || grid.length ==0 || grid[0].length==0){
            return max_area;
        }
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                max_area = Math.max(max_area, dfs(grid,i,j));
            }
        }
        return max_area;
    }
    private int dfs(int[][] grid,int r,int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[r].length || grid[r][c]==0){
            return 0; //边界条件，代表当前点不可达，所以没有面积
        }
        int area = 0;
        // 说明可达
        area+=1;// 面积增加
        grid[r][c] = 0; //标记下，因为到达过了，避免重复计算
        for(int[] dir:dirs){
            area +=dfs(grid, r+dir[0], c+dir[1]);
            //这里不需要恢复grid位置为1了，因为算的是连通面积，如果这个地方计算过了，以后这一块连通的都可以不算了，避免maxAreaOfIsland
            //重复计算
        }
        return area;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,1},{1,1}};
        System.out.println(new Solution().maxAreaOfIsland(grid));
    }
}