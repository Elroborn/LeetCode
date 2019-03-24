"""
Created on 2019/3/23 21:14
@File:解数独.py
@author: coderwangson
"""
"#codeing=utf-8"
# ref https://leetcode-cn.com/problems/sudoku-solver/comments/
class Solution(object):
    def dfs(self,board,row,col,block,i,j):
        while board[i][j]!='.':
            if j<8:
                j+=1
            else:
                i+=1
                j = 0
            # 遍历完
            if i>8:
                return True
        k = (i//3)*3+j//3
        for nums in '123456789':

            # 看行，列，块是否被用
            # 这样说明第一次用
            if row[i].get(nums,0)==0 and col[j].get(nums,0)==0 and block[k].get(nums,0)==0:
                row[i][nums] =1
                col[j][nums] =1
                block[k][nums] =1
                board[i][j] =nums
                if self.dfs(board,row,col,block,i,j):
                    return True
                # 说明递归失败，则把标注取消
                else:
                    row[i][nums] = 0
                    col[j][nums] = 0
                    block[k][nums] = 0
                    board[i][j] ='.'
        # 如果遍历完还诶有，则失败
        return False



    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        # 先对已经使用过的数字做下标记，这样方便以后dfs的时候不每次都进行循环，只需要取出即可
        row =[{} for i in range(9)]
        col = [{} for i in range(9)]
        block = [{} for i in range(9)]
        for i in range(9):
            for j in range(9):
                if board[i][j]!='.':
                    nums = board[i][j]
                    # 对第i行进行标注 ,如果为1 说明第一次，为二说明第二次
                    row[i][nums] = row[i].get(nums,0)+1
                    col[j][nums] = col[j].get(nums,0)+1
                    k = (i//3)*3 + j//3
                    block[k][nums] = block[k].get(nums,0)+1
        self.dfs(board,row,col,block,0,0)
        return board


print(Solution().solveSudoku([["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]))
