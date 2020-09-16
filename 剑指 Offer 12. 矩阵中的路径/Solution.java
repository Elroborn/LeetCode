/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-16 10:47:41
 * @FilePath: \leetcode\剑指 Offer 12. 矩阵中的路径\Solution.java
 * @LastEditTime: 2020-09-16 11:08:20
 */

class Solution {
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] vis = new boolean[board.length][board[0].length];
                    StringBuilder sb = new StringBuilder();
                    vis[i][j] = true;
                    sb.append(board[i][j]);
                    if(dfs(board,word,vis,i,j,sb)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, boolean[][] vis, int i, int j, StringBuilder sb) {
        if(sb.length() == word.length()){
            return sb.toString().equals(word);
        }
        for(int[] dir:dirs){
            int new_i = i+ dir[0];
            int new_j = j + dir[1];
            if(new_i>=0 && new_i<board.length && new_j>=0 && new_j<board[0].length && !vis[new_i][new_j] && board[new_i][new_j]==word.charAt(sb.length())){
                vis[new_i][new_j] = true;
                sb.append(board[new_i][new_j]);
                if(dfs(board, word, vis, new_i, new_j, sb)){
                    return true;
                }
                sb.deleteCharAt(sb.length()-1);
                vis[new_i][new_j] = false;
            }
        }
        return false;
    }
}