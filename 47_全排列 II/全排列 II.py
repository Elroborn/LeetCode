"""
Created on 2019/4/10 20:34
@File:全排列 II.py
@author: coderwangson
"""
"#codeing=utf-8"
import copy

# 无[2, 1, 2, 1]
# class Solution(object):
#     def perm(self,nums,i,tmp,res,book):
#         if i==len(nums):
#             res.append(copy.copy(tmp))
#             return
#         for j in range(len(nums)):
#             if book[j]!=0:continue
#             book[j] =1
#             tmp.append(nums[j])
#             self.perm(nums,i+1,tmp,res,book)
#             tmp.pop(nums[j])
#             book[j] = 0
#
#     def permuteUnique(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: List[List[int]]
#         """
#         res = []
#         tmp = []
#         book = [0 for i in nums]
#         self.perm(nums, 0, tmp,res,book)
#         # res = [tuple(x) for x in res]
#         # res = list(set(res))
#         # res = [list(x) for x in res]
#         return res
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