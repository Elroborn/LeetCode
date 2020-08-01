/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-05-11 09:18:06
 * @FilePath: \leetcode\200_岛屿数量\Solution1.java
 * @LastEditTime: 2020-08-01 16:56:31
 */ 
// class Solution{
//     int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
//     // DFS 深度搜索
//     public int numIslands(char[][] grid) {
//         int cnt = 0;
//         for(int i=0;i<grid.length;i++){
//             for(int j=0;j<grid[i].length;j++){
//                 if(grid[i][j]=='1'){
//                     cnt++;
//                     dfs(i, j, grid);
//                 }
//             }
//         }
//         return cnt;
//     }
//     public void dfs(int i,int j,char[][] grid){
//         for(int d=0;d<dir.length;d++){
//             int new_i = i + dir[d][0];
//             int new_j = j + dir[d][1];
//             if(new_i>=0 && new_i<grid.length && new_j>=0 && new_j<grid[new_i].length && grid[new_i][new_j]=='1'){
//                 grid[new_i][new_j] = '0';
//                 dfs(new_i, new_j, grid);
//             }
//         }

//     }
// }
class Solution1 {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int nums = 0;
        if(grid==null || grid.length ==0 || grid[0].length==0){
            return nums;
        }
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    nums++;
                    dfs(grid,i,j); //把其连通的都覆盖为0
                }
            }
        }
        return nums;
    }
    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] ='0'; //标记为不可达
        for(int[] dir:dirs){
            dfs(grid, r+dir[0], c+dir[1]);
        }
    }
}