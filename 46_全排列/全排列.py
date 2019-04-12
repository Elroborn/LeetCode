"""
Created on 2019/4/9 22:00
@File:全排列.py
@author: coderwangson
"""
"#codeing=utf-8"
# 参考的是啊哈算法中的 用一个book做标记
import copy
class Solution(object):
    def dfs(self,i,nums,book,tmp,res):
        if i == len(nums):
            res.append(copy.copy(tmp))


        for j in range(len(nums)):
            if book[j] == 0:
                book[j] =1
                tmp.append(nums[j])
                self.dfs(i+1,nums,book,tmp,res)
                tmp.remove(nums[j])
                book[j] =0


    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        book = [0 for i in nums]
        res = []
        tmp = []
        self.dfs(0,nums,book,tmp,res)
        return res
print(Solution().permute([1,1,2,2]))