"""
Created on 2019/4/16 21:47
@File:最大子序和.py
@author: coderwangson
"""
"#codeing=utf-8"
# ref https://blog.csdn.net/zwzsdy/article/details/80029796

# 扫描法
class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        curr = nums[0]
        max_sum = nums[0]
        for i in nums[1:]:
            if curr<0:
                curr= i
            else:
                curr +=i
            if curr>max_sum:max_sum = curr
        return max_sum

print(Solution().maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))



