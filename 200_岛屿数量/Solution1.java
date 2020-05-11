class Solution1 {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    // DFS 深度搜索
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    dfs(i, j, grid);
                }
            }
        }
        return cnt;
    }
    public void dfs(int i,int j,char[][] grid){
        for(int d=0;d<dir.length;d++){
            int new_i = i + dir[d][0];
            int new_j = j + dir[d][1];
            if(new_i>=0 && new_i<grid.length && new_j>=0 && new_j<grid[new_i].length && grid[new_i][new_j]=='1'){
                grid[new_i][new_j] = '0';
                dfs(new_i, new_j, grid);
            }
        }

    }
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.println(new Solution1().numIslands(grid));
    }
}