/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-05 10:31:17
 * @FilePath: \leetcode\130_被围绕的区域\Solution.java
 * @LastEditTime: 2020-08-05 13:00:21
 */
// https://leetcode-cn.com/problems/surrounded-regions/solution/zhi-xing-yong-shi-2-ms-zai-suo-you-java-ti-jiao-52/
class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        // 破提点是边上的O 只要和边上O相连的O就可以不被变成X，所以可以从边上的O出发，如果和边上O相连，可以变成一个临时的K
        // 最后将是K的变为O 还是O的变为X
        if(board == null || board.length ==0){
            return;
        }
        for(int i=0;i<board.length ;i++){
            for(int j = 0;j<board[i].length;j++){
                if(i==0 || i == board.length -1 || j==0 || j==board[i].length-1){ // 说明是边
                    if(board[i][j]=='O'){
                        // 将与边上O相连的所有O变为K
                        dfs(board,i,j);
                    }                    
                }
            }
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                board[i][j]=board[i][j]=='K'?'O':'X';
                // if(board[i][j]=='O'){
                //     board[i][j] ='X';
                // }
                // if(board[i][j]=='K'){
                //     board[i][j] ='O';
                // }
            }
        }
        
    }
    private void dfs(char[][] board,int i,int j){
        board[i][j] ='K';
        for(int[] dir:dirs){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if(new_i>=0 && new_i<board.length && new_j >=0 && new_j<board[new_i].length && board[new_i][new_j]=='O'){
                dfs(board, new_i, new_j);
            }
        }
    }
}