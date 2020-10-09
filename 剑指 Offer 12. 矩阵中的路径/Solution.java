/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-16 10:47:41
 * @FilePath: \leetcode\剑指 Offer 12. 矩阵中的路径\Solution.java
 * @LastEditTime: 2020-10-09 17:11:01
 */
class Solution {
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(dfs(board, word, i, j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,String word,int i,int j,int index){
        if(board[i][j]!=word.charAt(index)){
            return false;
        }
        if(index==word.length()-1){
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '#';
        for(int[] dir:dirs){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if(new_i>=0 && new_i<board.length && new_j>=0 && new_j<board[0].length && dfs(board, word, new_i,new_j,index+1)){
                return true;
            }
        }
        board[i][j] = tmp;
        return false;
    }

}