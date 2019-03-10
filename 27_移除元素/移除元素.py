"""
Created on 2019/3/10 13:55
@File:移除元素.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        i = -1
        j = 0
        while j <len(nums):
            if nums[j] != val:
                i+=1
                nums[i] = nums[j]
            j+=1
        return i+1

print(Solution().removeElement( [3,2,2,3],3))


