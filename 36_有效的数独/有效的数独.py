"""
Created on 2019/3/20 21:51
@File:有效的数独.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution:
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        # 每行的标记 比如rows[0]代表第一行 rows[0][x]代表第一出现了x这个数
        rows = [{} for i in range(9)]
        # 每列的标记
        cols = [{} for i in range(9)]
        # 每个小格子标记
        boxes = [{} for i in range(9)]
        # 遍历一遍，把每个数字对应到行，列以及格子里面标记
        for i in range(9):
            for j in range(9):
                if board[i][j]!='.':
                    nums = board[i][j]
                    # 对行标记 ，这里用个数，如果第一次出现，初始化为1 ，如果+2则说明第二次，则判断并且返回False
                    rows[i][nums] = rows[i].get(nums,0) +1
                    cols[j][nums] = cols[j].get(nums,0) +1
                    # k 代表第k个格子，根据i,j下标计算是属于哪个格子
                    k = (i//3)*3+j//3
                    boxes[k][nums] = boxes[k].get(nums,0)+1
                    if rows[i][nums]>1 or cols[j][nums]>1 or boxes[k][nums]>1:
                        return False
        return True



# l = ["5","3",".",".","7",".",".",".","."]
# s = "".join(l)

print(Solution().isValidSudoku([
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]))
