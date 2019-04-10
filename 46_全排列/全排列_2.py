"""
Created on 2019/4/9 22:00
@File:全排列.py
@author: coderwangson
"""
"#codeing=utf-8"
# ref https://leetcode-cn.com/problems/permutations/comments/  忘了二进制吧
import copy
class Solution(object):
    def perm(self,a,start,res):
        if start==len(a):
            res.append(copy.copy(a))
        for i in range(start,len(a)):
            a[start],a[i] = a[i],a[start]
            self.perm(a,start+1,res)
            a[start],a[i] = a[i],a[start]

    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        self.perm(nums,0,res)
        return res
print(Solution().permute([1,2,3]))