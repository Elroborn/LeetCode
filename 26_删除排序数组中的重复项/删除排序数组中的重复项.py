"""
Created on 2019/3/9 16:44
@File:删除排序数组中的重复项.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for i in nums[1:]:
            
