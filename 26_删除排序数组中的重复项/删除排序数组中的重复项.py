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
        j = 0
        if len(nums) ==0:
            return j
        for i in range(1,len(nums)):
            if nums[i] ==nums[j]:
                continue
            else:
                j+=1
                nums[j] = nums[i]
        return j+1

print(Solution().removeDuplicates([1]))


