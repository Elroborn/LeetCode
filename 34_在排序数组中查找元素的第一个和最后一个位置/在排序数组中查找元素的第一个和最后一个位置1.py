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
        # 则再次进行二分对左右都进行二分
        # 左边则找一个元素，这个元素不是target，但是这个元素的下个元素是target
        left = 0
        right = mid-1
        res = []
        while left <=right:
            mid = (right+left) //2
            if nums[mid]!=target and nums[mid+1] ==target:
                break
            # 因为nums[mid]是不可能>target的，所以就这两种情况
            if nums[mid]<target:
                left = mid+1
            elif nums[mid] ==target:
                right = mid-1
        # 说明没有找到一个nums[mid]!=target and nums[mid+1] ==target,那就是mid为边界了
        if left>right:
            res.append(mid)
        # 说明有满足条件的，那么mid+1为边界
        else:
            res.append(mid+1)
        left = mid+1
        right = len(nums) -1
        while left<=right:
            mid = (left+right) //2
            if nums[mid]!=target and nums[mid-1]==target:
                break
            if nums[mid] >target:
                right= mid-1
            elif nums[mid]==target:
                left = mid+1
        if left>right:
            res.append(mid)
        else:
            res.append(mid-1)
        return res

print(Solution().searchRange([1,2,3,4,4,4,5],4))

