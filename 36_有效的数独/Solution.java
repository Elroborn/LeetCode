class Solution {
    public boolean isValidSudoku(char[][] board) { //通过
        // check row
        for(int i = 0;i<board.length;i++){
            boolean used[] = new boolean[10];
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j]=='.'){
                    continue;
                }else{
                    if(used[board[i][j]-'0']){
                        return false;
                    }else{
                        used[board[i][j]-'0'] = true;
                    }
                }
            }
        }
        // check cols
        for(int i = 0;i<board[0].length;i++){
            boolean used[] = new boolean[10];
            for(int j = 0;j<board.length;j++){
                if(board[j][i]=='.'){
                    continue;
                }else{
                    if(used[board[j][i]-'0']){
                        return false;
                    }else{
                        used[board[j][i]-'0'] = true;
                    }
                }
            }
        }

        // check box 3*3
        for(int box = 0;box<9;box++){
            int start_i = (box/3)*3;
            int start_j = (box%3)*3;
            boolean used[] = new boolean[10];
            for(int i = 0;i<3;i++){
                for(int j = 0;j<3;j++){
                    if(board[start_i+i][start_j+j]=='.'){
                        continue;
                    }else{
                        if(used[board[start_i+i][start_j+j]-'0']){
                            return false;
                        }else{
                            used[board[start_i+i][start_j+j]-'0'] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}