/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-13 09:45:11
 * @FilePath: \leetcode\79_单词搜索\Solution1.java
 * @LastEditTime: 2020-09-13 10:03:35
 */
class Solution1 {
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    StringBuilder sb = new StringBuilder();
                    boolean[][] vis = new boolean[board.length][board[0].length];
                    sb.append(board[i][j]);
                    vis[i][j] = true;
                    if(dfs(board,i,j,word,sb,vis)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,int i,int j,String word,StringBuilder sb,boolean[][] vis){
        System.out.println(sb.toString());
        if(sb.length() >= word.length()){
            if(sb.toString().equals(word)){
                System.out.println("----");
                return true;
            }else{
                return false;
            }
        }
        boolean[] res = new boolean[4];
        int k = 0;
        for(int[] dir:dirs){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if(new_i>=0 && new_i<board.length && new_j>=0 && new_j<board[i].length && !vis[new_i][new_j] && board[new_i][new_j]==word.charAt(sb.length())){
                vis[new_i][new_j] = true;
                sb.append(board[new_i][new_j]);
                res[k++] = dfs(board, i, j, word, sb, vis);
                sb.deleteCharAt(sb.length()-1);
                vis[new_i][new_j] = false;
            }
            
        }
        return res[0] || res[1] || res[2] || res[3];

    }
    public static void main(String[] args) {
        
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean[][] vis = new boolean[board.length][board[0].length];
        String word = "ABCE";
        System.out.println(new Solution1().exist(board,word));
    }
}