"""
Created on 2019/4/14 20:16
@File:N皇后.py
@author: coderwangson
"""
"#codeing=utf-8"

import copy
class Solution(object):
    def check(self,tmp,i):
        for j in range(i):
            # 同一列
            if tmp[j]==tmp[i]:
                return False
            # 对角线
            if abs(tmp[j]-tmp[i]) ==abs(i-j):
                return False
        return True
    def dfs(self,i,n,tmp,tmp_pan,res):
        if i==n:
            res.append(list(map(lambda x:"".join(x),tmp_pan)))
            return res
        for p in range(n):
            tmp[i] = p
            if self.check(tmp,i):
                tmp_pan[i][p] ='Q'
                self.dfs(i+1,n,tmp,tmp_pan,res)
                tmp_pan[i][p] = '.'
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        tmp =[0 for i in range(n)]
        tmp_pan = [["."]*n for i in range(n)]
        res =[]
        self.dfs(0,n,tmp,tmp_pan,res)
        return res

print(Solution().solveNQueens(4))