"""
Created on 2019/4/14 20:47
@File:全排列 II_1.py
@author: coderwangson
"""
"#codeing=utf-8"
# ref http://www.cnblogs.com/grandyang/p/4359825.html

import copy
# 无[2, 1, 2, 1]
class Solution(object):
    def perm(self,nums,i,tmp,res,book):
        if i==len(nums):
            res.append(copy.copy(tmp))
            return
        for j in range(len(nums)):
            if book[j]!=0:continue
            # book[j - 1] == 0 比如[1 1 2 2]说明第一个1已经经过了，否则book[j-1]应该为1
            if j>0 and nums[j]==nums[j-1] and book[j-1]==0:continue
            book[j] =1
            tmp.append(nums[j])
            self.perm(nums,i+1,tmp,res,book)
            tmp.pop(-1)
            book[j] = 0

    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        tmp = []
        book = [0 for i in nums]
        nums = sorted(nums)
        self.perm(nums, 0, tmp,res,book)
        return res

print(Solution().permuteUnique([1,1,2,2]))