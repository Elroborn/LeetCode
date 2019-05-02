"""
Created on 2019/4/27 21:14
@File:第k个排列.py
@author: coderwangson
"""
"#codeing=utf-8"
import copy

class Solution(object):
    def dfs(self,data,i,count,k,res):
        if i==len(data):
            res.append(copy.copy(data))
            return

        for j in range(i,len(data)):
            data[i],data[j] = data[j],data[i]
            self.dfs(data,i+1,count,k,res)
            data[i], data[j] = data[j], data[i]
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        tmp = []
        res = []
        data = list(range(1,n+1))
        self.dfs(data,0,0,k,res)
        print(res)
        return None
print(Solution().getPermutation(3,3))

