"""
Created on 2019/2/27 21:47
@File:四数之和.py
@author: coderwangson
"""
"#codeing=utf-8"
class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums.sort()
        res = []
        for i in range(0,len(nums)-3):
            if i>0 and nums[i]==nums[i-1]:
                continue
            for left in range(i+1,len(nums)-2):
                tmp_target = target -nums[i]
                if left>i+1 and nums[left-1] ==nums[left]:
                    continue
                mid = left+1
                right = len(nums)-1
                while mid<right:
                    if nums[mid]+nums[right]+nums[left]==tmp_target:
                        res.append([nums[i],nums[left],nums[mid],nums[right]])
                        mid+=1
                        right-=1
                        while mid<right and nums[mid-1]==nums[mid]:mid+=1
                        while mid<right and nums[right]==nums[right+1]:right-=1
                    elif nums[mid]+nums[right]+nums[left]<tmp_target:
                        mid+=1
                    else:
                        right-=1

        return res




print(Solution().fourSum([-1,0,-5,-2,-2,-4,0,1,-2],-9))
