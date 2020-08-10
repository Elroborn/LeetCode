/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-10 10:40:53
 * @FilePath: \leetcode\79_单词搜索\Solution.java
 * @LastEditTime: 2020-08-10 14:58:53
 */
class Solution {
    private int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean state = dfs(board,i,j,word,0,vis);
                    if(state){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,int i,int j,String word,int index,boolean[][] vis){
        if(index == word.length()-1){
            return board[i][j] == word.charAt(index);
        }
        if(board[i][j] == word.charAt(index)){
            vis[i][j] = true;
            for(int[] dir:dirs){
                int new_i = i + dir[0];
                int new_j = j + dir[1];
                if(new_i>=0 && new_i<board.length && new_j>=0 && new_j<board[i].length && !vis[new_i][new_j] && dfs(board,new_i,new_j,word,index+1,vis)){
                    return true;
                }
            }
            vis[i][j] = false;
        }

        return false;
    }
    public static void main(String[] args) {
        
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean[][] vis = new boolean[board.length][board[0].length];
        String word = "ABCB";
        // System.out.println(new Solution().dfs(board, 0, 0, word, "A",vis));
    }
}