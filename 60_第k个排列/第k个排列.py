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
            count+=1
            if count ==k:
                res.append(copy.copy(tmp))
        for j in range(i,len(data)):
            tmp.append(data[j])
            data[i],data[j] = data[j],data[i]
            self.dfs(data,i+1,tmp,count,k,res)
            data[i], data[j] = data[j], data[i]
            tmp.remove(data[j])


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
        return res
print(Solution().getPermutation(4,3))

