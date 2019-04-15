"""
Created on 2019/4/10 20:34
@File:全排列 II.py
@author: coderwangson
"""
"#codeing=utf-8"

import copy
class Solution(object):
    def perm(self,a,start,res):
        if start==len(a):
            res.append(copy.copy(a))
        for i in range(start,len(a)):
            a[start],a[i] = a[i],a[start]
            self.perm(a,start+1,res)
            a[start],a[i] = a[i],a[start]

    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        self.perm(nums,0,res)
        res = [tuple(x) for x in res]
        res = list(set(res))
        res = [list(x) for x in res]
        return res
print(Solution().permuteUnique([1,1,2,2]))