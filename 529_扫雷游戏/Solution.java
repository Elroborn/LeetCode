/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-20 10:48:36
 * @FilePath: \leetcode\529_扫雷游戏\Solution.java
 * @LastEditTime: 2020-08-20 11:04:03
 */
class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
    public char[][] updateBoard(char[][] board, int[] click) {

        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }else if (board[click[0]][click[1]]=='E' && check(board, click[0], click[1])>0){
            board[click[0]][click[1]] = (char)('0'+check(board, click[0], click[1]));
            return board;
        }else{
            dfs(board,click[0],click[1]);
            return board;
        }

    }
    public void dfs(char[][] board,int i,int j){
        board[i][j] = 'B';
        for(int[] dir:dirs){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if(new_i>=0 && new_i<board.length && new_j>=0 && new_j<board[new_i].length){
                int bubble = check(board, new_i, new_j);
                if(board[new_i][new_j]=='E' && bubble==0){
                    dfs(board, new_i, new_j);
                }
                if(bubble>0){
                    board[new_i][new_j] = (char)('0' + bubble);
                }
            }
        }
    }
    public int check(char[][] board,int i,int j){
        int cnt = 0;
        for(int[] dir:dirs){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if(new_i>=0 && new_i<board.length && new_j>=0 && new_j<board[new_i].length && board[new_i][new_j]=='M'){
                cnt++;
            }
        }
        return cnt;
        
    }
    public static void main(String[] args) {
    }
}