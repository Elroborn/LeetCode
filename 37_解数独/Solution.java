import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * @Author: your name
 * @Date: 2020-09-15 10:12:04
 * @LastEditTime: 2020-09-15 11:40:21
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \leetcode\37_解数独\Solution.java
 */
class Solution {
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] colums = new boolean[9][9];
    private boolean[][][] blocks = new boolean[3][3][9];
    private boolean isValid = false;
    private List<int[]> spaces = new ArrayList<>();
    public void solveSudoku(char[][] board) {
        for(int i =0;i<9;i++){
            for(int j =0;j<9;j++){
                if(board[i][j]=='.'){
                    spaces.add(new int[]{i,j});
                }else{
                    int digits = board[i][j]-'0'-1;// -1 是因为数字是1-9 数组下标从0开始
                    rows[i][digits] = colums[j][digits] = blocks[i/3][j/3][digits] = true;
                }
            }
        }
        System.out.println("--");
        dfs(board,0);
    }

    private void dfs(char[][] board, int i) {
        if(i == spaces.size()){ //成功遍历
            isValid = true;
            return;
        }
        int[] space = spaces.get(i);
        int row = space[0], col= space[1];
        for(int d = 0;d<9 && !isValid;d++){
            if(!rows[row][d] && !colums[col][d] && !blocks[row/3][col/3][d]){
                rows[row][d] = colums[col][d] = blocks[row/3][col/3][d] = true;
                board[row][col] = (char)(d+'0'+1);
                dfs(board, i+1);
                rows[row][d] = colums[col][d] = blocks[row/3][col/3][d] = false;
            }
        }
    }
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        new Solution().solveSudoku(board);
        for(char[] c:board){
            for(char t:c){
                System.out.printf("%c",t);
            }
            System.out.println();
        }
                
    }
}