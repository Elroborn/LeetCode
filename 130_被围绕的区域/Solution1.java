/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-11 09:44:39
 * @FilePath: \leetcode\130_被围绕的区域\Solution1.java
 * @LastEditTime: 2020-08-11 09:56:15
 */
class Solution1 {
    private int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public void solve(char[][] board) {
        if(board == null || board.length ==0){
            return;
        }
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                // 在边界上
                if((i==0 || i==board.length -1 || j==0 || j==board[i].length-1) && board[i][j]=='O'){
                    // 以这个O为起点染色，将和其相连的O都变为K
                    dfs(board,i,j,vis);
                }
            }
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                board[i][j] = (board[i][j]=='K'?'O':'X'); 
            }
        }

    }
    public void dfs(char[][] board,int i,int j ,boolean[][] vis){
        board[i][j] = 'K';
        vis[i][j] = true;
        for(int[] dir:dirs){
            int new_i = i+ dir[0];
            int new_j = j + dir[1];
            if(new_i>=0 && new_i<board.length && new_j >=0 && new_j<board[i].length && !vis[new_i][new_j] && board[new_i][new_j]=='O'){
                dfs(board, new_i, new_j, vis);
            }
        }
        vis[i][j] = false;
    }
}