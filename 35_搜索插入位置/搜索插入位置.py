"""
Created on 2019/3/19 20:41
@File:搜索插入位置.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start = 0
        end = len(nums)-1
        while start<=end:
            mid = (start+end)//2
            if nums[mid] == target:
                break
            elif target > nums[mid]:
                start = mid+1
            else:
                end = mid-1
        else:
            return start
        return mid

print(Solution().searchInsert([1,2,3,6,7],3))
