"""
Created on 19.9.9 20:56
@File:单词搜索.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    direction = [[0,-1],[-1,0],[0,1],[1,0]]
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        m = len(board)

        n = len(board[0])
        mark = [[False for _ in range(n)] for j in range(m)]
        for i in range(m):
            for j in range(n):
                if self.search(board,word,mark,i,j,m,n,0):
                    return True
        return False


    def search(self,board,word,mark,x,y,m,n,index):
        if index == len(word)-1:
            return board[x][y] == word[index]
        if board[x][y] == word[index]:
            mark[x][y] =True
            for d in self.direction:
                new_x = x + d[0]
                new_y = y + d[1]
                if new_x>=0 and new_x < m and new_y>=0 and new_y<n and not mark[new_x][new_y] and self.search(board,word,mark,new_x,new_y,m,n,index+1):
                    return True
            mark[x][y] = False
        return False

print(Solution().exist([["a","a"]],"aaa"))