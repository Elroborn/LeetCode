"""
Created on 2019/4/9 22:00
@File:全排列.py
@author: coderwangson
"""
"#codeing=utf-8"
# ref https://leetcode-cn.com/problems/permutations/comments/  忘了二进制吧
import copy
class Solution(object):

    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums)==1:
            # 因为下面 y in 所以这里返回[]
            return [nums]
        res = []
        for x in nums:
            ys = nums+[]
            ys.remove(x)
            for y in self.permute(ys):
                res.append([x]+y)
        return res
print(Solution().permute([1,2,3]))