"""
Created on 2019/4/27 21:14
@File:第k个排列.py
@author: coderwangson
"""
"#codeing=utf-8"
import copy

class Solution(object):
    def dfs(self,data,i,tmp,count,k,res):
        if i==len(data):
            res.append(copy.copy(tmp))
            return

        for j in range(i,len(data)):
            tmp.append(str(data[j]))
            data[i],data[j] = data[j],data[i]
            self.dfs(data,i+1,tmp,count,k,res)
            data[i], data[j] = data[j], data[i]
            tmp.pop(-1)
        if len(res) ==k:
            return
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        tmp = []
        res = []
        data = list(range(1,n+1))
        self.dfs(data,0,tmp,0,k,res)
        return ''.join(res[k-1])
print(Solution().getPermutation(3,3))

