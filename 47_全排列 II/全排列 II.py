"""
Created on 2019/4/10 20:34
@File:全排列 II.py
@author: coderwangson
"""
"#codeing=utf-8"
import copy

class Solution(object):
    def perm(self,a,k,m,res):
        if k==m:
            res.append(copy.copy(a))
        for i in range(k,m):
            if i != k and a[i] == a[k]: continue
            a[k],a[i] = a[i],a[k]
            self.perm(a,k+1,m,res)
            a[k],a[i] = a[i],a[k]

    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        book = [0 for i in nums]
        res = []
        tmp = []
        nums = sorted(nums)
        self.perm(nums, 0, len(nums), res)
        return res
print(Solution().permuteUnique([2,2,1,1]))