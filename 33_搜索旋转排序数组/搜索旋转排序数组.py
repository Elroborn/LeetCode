"""
Created on 2019/3/18 20:01
@File:搜索旋转排序数组.py
@author: coderwangson
"""
"#codeing=utf-8"

# 不是logn 但是通过了
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        for i in range(len(nums)):
            if nums[i] ==target:return i
        return -1

print(Solution().search([4,5,6,7,0,1,2], 0))
