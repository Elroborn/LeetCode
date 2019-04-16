"""
Created on 2019/4/16 21:37
@File:N皇后 II.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    res = 0
    def __init__(self):
        Solution.res = 0
    def check(self, tmp, i):
        for j in range(i):
            # 同一列
            if tmp[j] == tmp[i]:
                return False
            # 对角线
            if abs(tmp[j] - tmp[i]) == abs(i - j):
                return False
        return True

    def dfs(self, i, n, tmp):
        if i == n:
            Solution.res+=1
            return
        for p in range(n):
            tmp[i] = p
            if self.check(tmp, i):
                self.dfs(i + 1, n, tmp)
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: int
        """
        tmp =[0 for i in range(n)]
        self.dfs(0,n,tmp)
        return Solution.res
for i in range(4):
    print(Solution().totalNQueens(1))
