"""
Created on 2019/6/18 15:31
@File:组合.py
@author: coderwangson
"""
"#codeing=utf-8"
#ref https://segmentfault.com/a/1190000016503581
import copy
class Solution(object):
    def dfs(self,i,n,k,res,current):
        if len(current) ==k:
            res.append(copy.copy((current)))
        else:
            for tmp in range(i,n+1):
                current.append(tmp)
                self.dfs(tmp+1,n,k,res,current)
                current.pop()

    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        res = []
        self.dfs(1,n,k,res,[])
        return res
class Solution1:
    def backtrack(self, res, n, nums, k, current):
        if len(current) == k:
            res.append(current.copy())
        else:
            for i in range(nums, n + 1):
                current.append(i)
                self.backtrack(res, n, i + 1, k, current)
                current.pop()

    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        res = []
        self.backtrack(res, n, 1, k, [])
        return res
print(Solution().combine(4,2))
