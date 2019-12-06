"""
Created on 19.9.11 21:25
@File:删除排序数组中的重复项 II.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)<=2:
            return len(nums)
        i = 1
        for j in nums[2:]:
            if j != nums[i] or (j==nums[i] and j!=nums[i-1]):
                nums[i+1] = j
                i+=1
        return i+1
print(Solution().removeDuplicates([0,0,1]))




