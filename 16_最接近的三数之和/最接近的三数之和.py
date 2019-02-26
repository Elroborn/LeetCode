"""
Created on 2019/2/25 20:44
@File:最接近的三数之和.py
@author: coderwangson
"""
"#codeing=utf-8"
class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums = sorted(nums)
        Min = nums[0]+nums[1]+nums[2]
        for left in range(0,len(nums)-2):
            mid = left+1
            right = len(nums)-1
            while mid<right:
                tmp = nums[left]+nums[mid]+nums[right]
                if abs(target -tmp)<abs(target-Min):
                    Min = tmp
                if target ==Min:
                    return Min
                if tmp <target:
                    mid+=1
                else:
                    right-=1
        return Min

print(Solution().threeSumClosest([-1,2,1,4],1))
