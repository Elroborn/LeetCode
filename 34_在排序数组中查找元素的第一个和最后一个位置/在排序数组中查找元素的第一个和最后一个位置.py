"""
Created on 2019/3/19 20:02
@File:在排序数组中查找元素的第一个和最后一个位置.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        start = 0
        end = len(nums) -1
        while start<=end:
            mid = (start+end)//2
            if target == nums[mid]:
                break
            elif target<nums[mid]:
                end = mid-1
            else:
                start = mid+1
        # 如果没有进if
        else:
            return [-1,-1]
        # 如果没有进上面的else，则说明进了if的break，则说明有戏
        left = mid
        right = mid
        while left>=start:
            if nums[left] == target:
                left-=1
            else:
                break
        while right<=end:
            if nums[right]==target:
                right+=1
            else:
                break

        return [left+1,right-1]


print(Solution().searchRange([1,2,3,4,4,4,5],4))

