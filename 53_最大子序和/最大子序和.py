"""
Created on 2019/4/16 21:47
@File:最大子序和.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max = nums[0]
        m = 0
        for i in range(nums):
            t = m + nums
            if t
