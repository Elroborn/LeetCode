"""
Created on 2019/4/16 21:47
@File:最大子序和.py
@author: coderwangson
"""
"#codeing=utf-8"

# 超时
class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_sum = nums[0]
        for i in range(len(nums)):
            sum = 0
            for j in range(i,len(nums)):
                sum+=nums[j]
                if sum>max_sum:
                    max_sum = sum
        return max_sum

print(Solution().maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))



